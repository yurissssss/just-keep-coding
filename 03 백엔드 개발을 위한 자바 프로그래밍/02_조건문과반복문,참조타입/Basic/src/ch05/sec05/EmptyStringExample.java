package ch05.sec05;

public class EmptyStringExample {
    public static void main(String[] args) {
        //빈 문자열을 String 객체로 생성
        String hobby = "";

        if (hobby.equals("")) {
            System.out.println("hobby 변수가 참조하는 String 객체는 빈 문자열");
            //hobby 변수가 참조하는 String 객체는 빈 문자열
        }
    }
}
