package ch04.sec04;

public class MultiplicationTableExample {
    public static void main(String[] args) {

        //가로로 나열
        for (int i=1; i<=9; i++) {
            for (int j=2; j<=9; j++) {
                System.out.printf("%d x %d = %-4d", j, i, i*j);
            }
            System.out.println();
        }

//        //단수
//        for (int i=2; i<=9; i++) {
//            System.out.printf("***%d단***\n", i);
//
//            //구구단 나열
//            for(int j=1; j<=9; j++) {
//                System.out.printf("%d x %d = %d\n", i, j, i*j);
//            }
//        }
    }
}
