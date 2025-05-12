package ch05.sec09;

public class ArrayCopyByForExample {
    public static void main(String[] args) {
        int[] oldIntArray = {1, 2, 3};

        //요소가 5개인 새로운 배열 선언
        int[] newIntArray = new int[5];

        //배열 요소 복사
        for (int i=0; i<oldIntArray.length; i++) {
            newIntArray[i] = oldIntArray[i];
        }

        //베열 요소 출력
        for (int i=0; i<newIntArray.length; i++) {
            System.out.print(newIntArray[i] + ", ");
        }
    }
}
