package ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");

        //문장 스트림을 단어 스트림으로 변환 후 출력
        list1.stream()  //List<String>에서 Stream<String> 생성
                //flatMap(): 각 스트림을 단일 스트림으로 병합
                //data.split(" "): 공백을 기준으로 문자열을 분리하여 문자열 배열 생성
                .flatMap(data -> Arrays.stream(data.split(" ")))
                //모든 단어를 개별적으로 출력
                .forEach(word -> System.out.println(word));

        System.out.println();

        List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
        //문자열 숫자 목록 스트림을 숫자 스트림응로 변환 후 출력
        list2.stream()
                .flatMapToInt(data -> {
                    //문자열을 개별 숫자로 분리
                    String[] strArr = data.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i=0;i<strArr.length; i++) {
                        //공백 제거 후 정수로 변환
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    return Arrays.stream(intArr);
                })
                .forEach(number -> System.out.println(number));
    }
}
