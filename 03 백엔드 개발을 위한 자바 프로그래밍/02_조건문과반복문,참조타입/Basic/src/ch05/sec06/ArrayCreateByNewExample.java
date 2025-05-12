package ch05.sec06;

public class ArrayCreateByNewExample {
    public static void main(String[] args) {
        //정수 요소 3개 가지는 정수 배열 선언
        //초기화 X
        int[] arr1 = new int[3];

        //배열의 내용 출력
        for (int i=0; i<3; i++) {
            System.out.println("arr1[" + i + "]: " + arr1[i]);
            //0
        }

        System.out.println("------------");

        //문자열 요소 3개 가지는 문자열 배열 선언
        //초기화 X
        String[] arr2 = new String[3];

        //배열의 내용 출력
        for (int i=0; i<3; i++) {
            System.out.println("arr2[" + i + "]: " + arr2[i]);
            //null
        }
    }
}
