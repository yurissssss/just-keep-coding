package ch14.exam;

public class MusicRunnable implements Runnable {
    @Override
    public void run() {
        for (int i=0; i<6; i++) {  //6회 반복
            System.out.println("음악을 재생합니다.");
            try {
                Thread.sleep(500);  //0.5초 간격
            } catch (InterruptedException e) {
                //예외 발생 시 무시
            }
        }
    }
}
