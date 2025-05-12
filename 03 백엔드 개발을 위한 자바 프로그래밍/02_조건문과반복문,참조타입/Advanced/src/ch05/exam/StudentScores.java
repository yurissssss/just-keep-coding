package ch05.exam;

import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        boolean run = true;  //무한루프
        int students = 0;  //학생 수
        //선언만, 아직 할당 X
        //Heap 영역에 객체 생성 X
        int[] scores = null;  //점수

        Scanner scanner = new Scanner(System.in);

        while (run) {
            System.out.println("----------------------------------------------");
            System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
            System.out.println("----------------------------------------------");
            System.out.print("선택> ");

            int menuNum = scanner.nextInt();

            switch (menuNum) {
                //입력받은 학생수 저장
                case 1 -> {
                    System.out.print("학생 수> ");
                    students = scanner.nextInt();
                }
                case 2 -> {
                    //학생수만큼의 요소를 갖는 배열 생성
                    scores = new int[students];
                    //학생들의 점수 입력받기
                    for (int i=0; i<scores.length; i++) {
                        System.out.printf("scores[%d]: ", i);
                        scores[i] = scanner.nextInt();
                    }
                }
                //점수 출력
                case 3 -> {
                    for (int i=0; i<scores.length; i++) {
                        System.out.println("scores[" + i + "]: " + scores[i]);
                    }
                }
                case 4 -> {
                    //최고점수 찾기
                    int max = 0;
                    for (int i=0; i<scores.length; i++) {
                        if (scores[i] > max) {
                            max = scores[i];
                        }
                    }
                    System.out.println("최고 점수: " + max);

                    //평균 구하기
                    int sum = 0;
                    for (int i=0; i<scores.length; i++) {
                        sum += scores[i];
                    }
                    System.out.println("평균 점수: " + sum/scores.length);
                }
                //프로그램 종료
                case 5 -> {
                    System.out.println("프로그램 종료");
                    run = false;
                }
                //예외처리
                default -> System.out.println("1-5 사이의 숫자만 입력할 수 있습니다.");
            }
        }
    }
}
