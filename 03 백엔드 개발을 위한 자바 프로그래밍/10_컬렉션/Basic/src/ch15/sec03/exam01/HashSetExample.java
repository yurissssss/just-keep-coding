package ch15.sec03.exam01;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        //다형성
        //Set: 인터페이스, HashSet: 구현클래스
        //나중에 TreeSet을 쓰고 싶다면 코드 한 줄만 수정하면 됨
        //Set<String> set = new TreeSet<String>();
        Set<String> set = new HashSet<String>();

        //객체 저장
        set.add("Java");
        set.add("JDBC");
        set.add("Servlet/JSP");
        set.add("Java");  //Set: 중복 허용 X -> 저장 X
        set.add("iBATIS");

        //저장된 객체 수 출력
        int size = set.size();
        System.out.println("총 객체 수: " + size);
        //총 객체 수: 4
    }
}
