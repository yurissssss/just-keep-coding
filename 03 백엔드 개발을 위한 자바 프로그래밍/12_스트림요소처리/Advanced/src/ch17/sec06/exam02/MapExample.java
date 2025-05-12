package ch17.sec06.exam02;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MapExample {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        //IntStream으로 선언하고 DoubleStream으로 변경하는 이유
        // -> 필요한 시점에만 double로 변환하기 때문에 메모기를 적게 사용
        // -> 기본형(int)에 특화된 메서드 (sun(), average(), max() 등) 사용 가능
        IntStream intStream = Arrays.stream(intArray);
        intStream
                .asDoubleStream()  //DoubleStream으로 변경
                .forEach(d -> System.out.println(d));

        System.out.println();

        intStream = Arrays.stream(intArray);
        intStream
                .boxed()  //Stream<Integer> - 기본형을 참조형으로 박싱
                //intValue() - 기본형 스트림(IntStream)에서는 사용할 수 없는 메서드
                .forEach(obj -> System.out.println(obj.intValue()));
    }
}
