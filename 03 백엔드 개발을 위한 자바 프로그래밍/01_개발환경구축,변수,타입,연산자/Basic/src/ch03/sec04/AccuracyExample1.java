package ch03.sec04;

public class AccuracyExample1 {
    public static void main(String[] args) {
        int apple = 1;
        double pieceUnit = 0.1;
        //0.1은 이진수에서 정확히 표현 X
        //-> 근사값으로 저장 --> 연산 결과에 오차 포함
        int number = 7;

        double result = apple - number*pieceUnit;
        System.out.println("사과 1개에서 남은 양: " + result);
        //0.29999999999999993
    }
}
