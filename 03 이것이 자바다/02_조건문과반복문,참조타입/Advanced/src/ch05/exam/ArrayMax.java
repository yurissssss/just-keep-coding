package ch05.exam;

public class ArrayMax {
    public static void main(String[] args) {
        int[] array = { 1, 5, 3, 8, 2 };
        int max = 0;

        //array 배열 순회
        for (int x : array) {
            //기존 최대값보다 더 큰 값이 나타나면
            if (x > max) {
                //최대값 변경
                max = x;
            }
        }
        System.out.println("최대값 : " + max);
        //8
    }
}