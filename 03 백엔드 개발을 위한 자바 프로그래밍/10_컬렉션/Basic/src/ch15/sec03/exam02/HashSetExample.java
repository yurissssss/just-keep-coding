package ch15.sec03.exam02;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        //HashSet 컬렉션 생성
        Set<Member> set = new HashSet<>();

        //Member 객체 저장
        set.add(new Member("홍길동", 30));
        set.add(new Member("홍길동", 30));

        //String은 "이름 & 나이 같으면" 같은 객체로 취급
        // (equals() -> true, hashCode()같음)
        //직접 만든 클래스에서는
        //"이름 & 나이 같더라도" 다른 객체로 취급
        // -> hashCode(), equals() 재정의
        // --> 동등 객체로 인식, 객체 1개만 저장

        //저장된 객체 수 출력
        System.out.println("총 객체 수: " + set.size());
        //총 객체 수: 1
    }
}
