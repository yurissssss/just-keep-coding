package org.scoula.lib;

import java.util.Scanner;

public class Input {
    static Scanner scanner = new Scanner(System.in);

    //문자열 입력

    //매개변수: title
    public static String read(String title) {
        System.out.print(title);
        return scanner.nextLine();  //사용자 입력값
    }

    //매개변수: title, defaultValue
    public static String read(String title, String defaultValue) {
        System.out.printf("%s(%s): ", title, defaultValue);
        String answer = scanner.nextLine();

        //엔터 -> defaultValue 리턴, 입력값 -> answer 리턴
        return answer.isEmpty() ? defaultValue : answer;
    }

    //정수 입력

    //매개변수: title
    public static int readInt(String title) {
        System.out.print(title);
        //사용자 입력값 정수로 변환
        int answer = scanner.nextInt();
        scanner.nextLine();  //엔터 제거용
        return answer;
    }

    //yes/no 확인

    //매개변수: title, (Y/n)
    public static boolean confirm(String title, boolean defaultValue) {
        //defaultValue: true -> (Y/n), false -> (y/N)
        String yesNo = defaultValue ? "(Y/n)" : "(y/N)";
        System.out.printf("%s %s: ", title, yesNo);

        String answer = scanner.nextLine();
        //엔터만 쳤다면
        if (answer.isEmpty()) {
            return defaultValue;  //기본값 반환
        }
        return answer.equalsIgnoreCase("y");
    }

    public static boolean confirm(String title) {
        return confirm(title, true);
    }
}
