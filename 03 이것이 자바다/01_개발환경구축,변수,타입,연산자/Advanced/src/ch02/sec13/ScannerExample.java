package ch02.sec13;

//Scanner가 java.util 패키지 안에 있다는 것을 컴파일러에게 알려줌
import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("x 값 입력: ");
        //next() : 단어 한 개(공백 기준) 읽음
        //nextLine() : 한 줄 전체(엔터 기준) 읽음
        String strX = scanner.nextLine();
        int x = Integer.parseInt(strX);

        System.out.println("y 값 입력: ");
        String strY = scanner.nextLine();
        int y = Integer.parseInt(strY);

        int result = x + y;
        System.out.println("x + y = " + result);
        System.out.println();

        while(true) {
            System.out.println("입력 문자열: ");
            String data = scanner.nextLine();
            if (data.equals("q")) {
                //입력된 문자열이 "q"라면 반복문 종료
                break;
            }
            System.out.println("출력 문자열: " + data);
            System.out.println();
        }
        System.out.println("종료");
    }
}
