package ch12.sec07;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        int[] selectNumber = new int[6];

        //시드: 랜덤 숫자를 처음부터 뽑기 시작할 기준값 -> 무작위 수를 생성하는 "출발점"이 되는 숫자
        Random random = new Random(3);
        //Random random = new Random(3); -> 시드 매번 달라짐 = 현재 시간 기반
        System.out.println("선택번호: ");
        for (int i=0; i<6; i++) {
            //nextInt: 무작위 정수 생성
            selectNumber[i] = random.nextInt(45) + 1;  //1 ~ 45
            System.out.println(selectNumber[i] + " ");
        }
        System.out.println();

        int[] winningNumber = new int[6];
        random = new Random(5);  //시드 5로 변경 -> 다른 랜덤 결과 생성
        System.out.println("당첨번호: ");
        for (int i=0; i<6; i++) {
            winningNumber[i] = random.nextInt(45) + 1;
            System.out.println(winningNumber[i] + " ");
        }
        System.out.println();

        //오름차순으로 정렬
        Arrays.sort(selectNumber);
        Arrays.sort(winningNumber);
        //배열 항목 비교
        boolean result = Arrays.equals(selectNumber, winningNumber);
        System.out.println("당첨여부: ");
        if (result) {
            System.out.println("1등에 당첨되셨습니다.");
        } else {
            System.out.println("당첨되지 않았습니다.");
        }
    }
}
