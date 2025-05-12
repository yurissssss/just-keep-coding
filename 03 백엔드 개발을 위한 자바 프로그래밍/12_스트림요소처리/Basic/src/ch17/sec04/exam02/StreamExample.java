package ch17.sec04.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        String[] strArray = {"홍길동", "신용권", "김미나"};
        Stream<String> strStream = Arrays.stream(strArray);
        //마지막은 ',' 출력 안 하기
        strStream.forEach(item -> {
            if (item == strArray[2]) {
                System.out.println(item);
            } else {
                System.out.print(item + ",");
            }
        });
        System.out.println();

        int[] intArray = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(intArray);
        //마지막은 ',' 출력 안 하기
        intStream.forEach(item -> {
            if (item == intArray[4]) {
                System.out.println(item);
            } else {
                System.out.print(item + ",");
            }
        });
    }
}
