package ch05.exam;

public class SumAverage {
    public static void main(String[] args) {
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        //총합
        int sum = 0;
        int count = 0;  //배열 요소의 개수
        //행
        for (int i=0; i<3; i++) {
            //열
            for (int j=0; j<array[i].length; j++) {
                sum += array[i][j];
                count++;  //배열 요소의 개수 누적
            }
        }
        System.out.println("총합: " + sum);
        //총합: 881

        //평균
        //System.out.println("count: " + count);
        //count: 10
        double avg = (double) sum / count;
        System.out.println("평균: " + avg);
        //평균: 88.1
    }
}
