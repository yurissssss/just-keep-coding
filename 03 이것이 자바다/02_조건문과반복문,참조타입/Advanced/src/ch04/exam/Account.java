package ch04.exam;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        boolean run = true;  //무한루프
        int balance = 0;  //잔고
        Scanner scanner = new Scanner(System.in);

        //무한루프
        while (run) {
            System.out.println("-----------------------------");
            System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
            System.out.println("-----------------------------");
            System.out.print("선택> ");

            int menuNum = scanner.nextInt();

            switch (menuNum) {
                //예금
                case 1 -> {
                    System.out.print("예금액> ");
                    balance += scanner.nextInt();
                    break;
                }
                //출금
                case 2 -> {
                    System.out.print("출금액> ");
                    balance -= scanner.nextInt();
                    break;
                }
                //잔고
                case 3 -> {
                    System.out.print("잔고> ");
                    System.out.println(balance);
                    break;
                }
                //종료
                case 4 -> {
                    run = false;  //무한루프 종료
                    System.out.println("프로그램 종료");
                    break;
                }
            }
            System.out.println();
        }
    }
}
