package ch14.sec03.exam02;

import java.awt.*;  //Toolkit

public class BeepPrintExample {
    public static void main(String[] args) {
        //Runnable 인터페이스를 이용해 새로운 작업 스레드 생성
        Thread thread = new Thread(new Runnable() {
            @Override  //Runnable의 run() 오버라이드
            public void run() {
                //실행 코드

                //비프음을 발생시키기 위한 Toolkit 객체
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                //Toolkit -> MacOS 입력 시스템 초기화
                //2025-04-26 21:54:52.488 java[4480:391903] +[IMKClient subclass]: chose IMKClient_Modern
                //2025-04-26 21:54:52.488 java[4480:391903] +[IMKInputSession subclass]: chose IMKInputSession_Modern

                for (int i=0; i<5; i++) {
                    toolkit.beep();  //비프음 출력
                    try {
                        Thread.sleep(500);  //0.5초 주기
                    } catch (Exception e) {
                        //예외 발생 시  무시
                    }
                }
            }
        });
        //작업 스레드 실행
        thread.start();

        //메인 스레드가 실행할 코드
        for (int i=0; i<5; i++) {
            System.out.println("띵");  //"띵" 출력
            try {
                Thread.sleep(500);  //0.5초 주기
            } catch (Exception e) {
                //예외 발생 시  무시
            }
        }
    }
}
