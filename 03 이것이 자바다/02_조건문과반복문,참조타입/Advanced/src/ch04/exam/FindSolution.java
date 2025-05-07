package ch04.exam;

public class FindSolution {
    public static void main(String[] args) {
        //x, y: 10이하의 자연수
        for (int x=1; x<=10; x++) {
            for (int y=1; y<=10; y++) {
                if (4*x + 5*y == 60) {
                    System.out.printf("(%d, %d)\n", x, y);
                    //(5, 8)
                    //(10, 4)
                }
            }
        }
    }
}
