package org.scoula.security.account.mapper;

import org.scoula.security.account.domain.MemberVO;

public interface UserDetailsMapper {
    // 로그인 처리할 때 db 연동할 기능을 정의하면 됨.!
    // username(id) 주고 회원정보를 검색하자.!
    // security에서 'username'이라는 변수 사용
    //      -> 그대로 사용 ('id'라고 써도 되긴 함)
    MemberVO get(String username);
}
