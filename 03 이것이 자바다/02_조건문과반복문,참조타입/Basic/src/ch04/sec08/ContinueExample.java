package ch04.sec08;

public class ContinueExample {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            //홀수인 경우 건너뛰기
            if (i%2 == 1) {
                continue;
            }
            System.out.printf("%-2d", i);
            //2 4 6 8 10
        }
    }
}
