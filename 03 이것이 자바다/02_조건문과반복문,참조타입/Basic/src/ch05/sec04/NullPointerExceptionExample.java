package ch05.sec04;

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        int[] intArray = null;
        //Error: intArray가 참조하는 배열 객체 X
        intArray[0] = 10;

        String str = null;
        //Error: str이 참조하는 문자열 객체 X
        System.out.println("총 문자 수: " + str.length());
    }
}
