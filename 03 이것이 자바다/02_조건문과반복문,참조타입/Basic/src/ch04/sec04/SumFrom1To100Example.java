package ch04.sec04;

public class SumFrom1To100Example {
    public static void main(String[] args) {
        int sum = 0;
        //카운터 변수
        //for문 안에서 선언해주면 밖에서는 사용할 수 없으므로 미리 선언
        int i=1;

        for (i=1; i<=100; i++) {
            sum += i;
        }

        //i=100 -> sum += 100 -> i++ => i=101
        System.out.println("1~" + (i-1) + " 합: " + sum);
        //1~100 합: 5050
    }
}
