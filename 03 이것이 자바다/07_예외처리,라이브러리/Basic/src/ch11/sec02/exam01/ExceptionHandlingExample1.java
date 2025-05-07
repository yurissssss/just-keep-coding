package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        int result = data.length();
        //data = null -> null인 상태로 메서드 접근 -> NullPointerException 발생
        System.out.println("문자 수: " + result);
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        //매개변수값으로 'null'대입
        System.out.println("[프로그램 종료]");
    }
}
