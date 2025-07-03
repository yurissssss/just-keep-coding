package org.scoula.common.pagination;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 페이지 요청 정보를 담는 클래스
 *  - page: 요청 페이지 번호 (1부터 시작)
 *  - amount: 한 페이지에 보여줄 항목 수
 *  - getOffset(): DB 쿼리 시 사용할 offset 계산
 *
 *  selet * from tbl_board order by no desc
 *  limit #{offset}, #{amount}
 */

@Data
// Getter, Setter, toString, equals, hashCode 자동 생성
@AllArgsConstructor(access = AccessLevel.PRIVATE)
// 모든 필드를 파라미터로 갖는 생성자를 private으로 생성
public class PageRequest {
    private int page; // 요청 페이지
    private int amount; // 한 페이지 당 데이터 건수

    public PageRequest() {
        page = 1;
        amount = 10;
    }

    public static PageRequest of(int page, int amount) {
        return new PageRequest(page, amount);
    }

    // offset 값 계산
    public int getOffset() {
        // page1: (1-1) * 10 = 0
        // page2: (2-1) * 10 = 10
        return (page - 1) * amount;
    }
}