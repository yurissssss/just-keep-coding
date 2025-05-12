package ch04.exam;

public class ForSum3 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i=0; i<100; i++) {
            if (i%3 == 0) {
                sum += i;
            }
        }

//        //while
//        int i=1;
//        int sum2 = 0;
//        while(i<=100) {
//            if (i%3 == 0) {
//                sum2 += i;
//            }
//            i++;
//        }

        System.out.println("1-100까지의 정수 중 3의 배수의 총합: " + sum);
        //1-100까지의 정수 중 3의 배수의 총합: 1683
    }
}
