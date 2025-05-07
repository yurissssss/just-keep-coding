package ch05.sec05;

public class EqualsExample {
    public static void main(String[] args) {
        String strVar1 = "홍길동";
        String strVar2 = "홍길동";

        //두 변수의 참조 비교
        if (strVar1 == strVar2) {
            System.out.println("strVar1과 strVar2는 참조가 같음");
            //strVar1과 strVar2는 참조가 같음
        } else {
            System.out.println("strVar1과 strVar2는 참조가 다름");
        }

        //두 변수의 내용(문자열) 비교
        if (strVar1.equals(strVar2)) {
            System.out.println("strVar1과 strVar2는 문자열이 같음");
            //strVar1과 strVar2는 문자열이 같음
        } else {
            System.out.println("strVar1과 strVar2는 문자열이 다름");
        }

        String strVar3 = new String("홍길동");
        String strVar4 = new String("홍길동");

        //두 변수의 참조 비교
        if (strVar3 == strVar4) {
            System.out.println("strVar3과 strVar4는 참조가 같음");
        } else {
            System.out.println("strVar3과 strVar4는 참조가 다름");
            //strVar3과 strVar4는 참조가 다름
        }

        //두 변수의 내용(문자열) 비교
        if (strVar3.equals(strVar4)) {
            System.out.println("strVar3과 strVar4는 문자열이 같음");
            //strVar3과 strVar4는 문자열이 같음
        } else {
            System.out.println("strVar3과 strVar4는 문자열이 다름");
        }
    }
}
