package ch15.sec03.exam03;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        //HashSet 컬렉션 생성
        //Set<String> set = new HashSet<>();
        Set<String> set = new HashSet<String>();

        //객체 추가 (중복 X, 순서 보장 X)
        set.add("Java");
        set.add("JDBC");
        set.add("JSP");
        set.add("Spring");

        //Iterator 패턴으로 순회하며 각 요소 출력
        // -> 안전하게 remove 가능
        Iterator<String> iterator = set.iterator();
        //가져올 객체가 있는지 확인
        while(iterator.hasNext()) {
            //다음 객체 하나 갖고오기
            String element = iterator.next();
            System.out.println(element);
            if (element.equals("JSP")) {
                //"JSP" 객체 컬렉션에서 제거
                iterator.remove();
            }
        }
        System.out.println();
        //Java
        //Spring

        //"JDBC" 객체 제거
        set.remove("JDBC");

        //향상된 for 문 (for-each) 으로 순회하며 각 요소 출력
        for (String element : set) {
            System.out.println(element);
            //Java
            //Spring
        }
    }
}
