package ch04.sec04;

public class PrintFrom1To10Example {
    public static void main(String[] args) {
        for (int i=1; i<=10; i++) {
            System.out.printf("%-2d", i);
            //1 2 3 4 5 6 7 8 9 10

            //System.out.print(i + " ");
            //1 2 3 4 5 6 7 8 9 10
        }
    }
}
