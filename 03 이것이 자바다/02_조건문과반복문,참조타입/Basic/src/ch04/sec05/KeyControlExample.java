package ch04.sec05;

import java.util.Scanner;

public class KeyControlExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;
        int speed = 0;

        //run = true -> 무한반복
        while(run) {
            System.out.println("-------------------------");
            System.out.println("1. 증속 | 2. 감속 | 3. 중지");
            System.out.println("-------------------------");
            System.out.print("선택: ");

            //키보드 입력 내용 읽음
            String strNum = scanner.nextLine();

            if(strNum.equals("1")) {
                speed++;
                System.out.printf("현재 속도 = %d\n", speed);
            } else if(strNum.equals("2")) {
                speed--;
                System.out.println("현재속도: " + speed);
            } else if (strNum.equals("3")) {
                //반복문 종료
                run = false;
                System.out.println("프로그램 종료");
            }
        }
    }
}
