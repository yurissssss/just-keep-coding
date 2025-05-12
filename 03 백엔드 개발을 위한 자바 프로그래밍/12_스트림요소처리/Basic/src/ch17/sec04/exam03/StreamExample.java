package ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
    //합계를 구하기 위한 변수
    public static int sum;

    public static void main(String[] args) {
        //1 ~ 100 탐색 -> 합 구하기
        IntStream stream = IntStream.rangeClosed(1, 100);
        stream.forEach(a -> sum += a);
        System.out.println("총합: " + sum);
    }
}
