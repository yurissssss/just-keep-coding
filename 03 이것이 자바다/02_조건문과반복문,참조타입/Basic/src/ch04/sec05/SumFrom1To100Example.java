package ch04.sec05;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;
        //카운터 변수
        int i = 1;

        while (i<=100) {
            sum += i;
            i++;
        }
        System.out.printf("%d~%d 합: %d", 1, i-1, sum);
        //1~100 합: 5050
    }
}
