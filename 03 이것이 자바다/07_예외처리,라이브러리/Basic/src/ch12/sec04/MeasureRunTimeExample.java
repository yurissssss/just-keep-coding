package ch12.sec04;

public class MeasureRunTimeExample {
    public static void main(String[] args) {
        //System.nanoTime(): 현재시간을 나노초 단위로 리턴 -> 시간 간격 측정용 (정밀도 매우 높음)
        //System.currentTimeMillis(): 현재 시각 측정용 (정밀도 낮음)
        long time1 = System.nanoTime();  //코드 실행 시작 시간을 nanoTime()으로 저장
        int sum = 0;
        for (int i = 0; i < 1000000; i++) {
            sum += i;
        }
        long time2 = System.nanoTime();  //코드 실행 끝나는 시간을 nanoTime()으로 저장

        System.out.println("1~1000000까지의 합: " + sum);
        System.out.println("계산에 " + (time2-time1) + "나노초가 소요되었습니다.");
    }
}
