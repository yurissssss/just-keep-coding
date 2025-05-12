package ch05.sec06;

public class ArrayCreateByValueListExample1 {
    public static void main(String[] args) {
        String[] season = {"Spring", "Summer", "Fall", "Winter"};

        System.out.println("season[0]: " + season[0]);
        //season[0]: Spring
        System.out.println("season[1]: " + season[1]);
        //season[1]: Summer
        System.out.println("season[2]: " + season[2]);
        //season[2]: Fall
        System.out.println("season[3]: " + season[3]);
        //season[3]: Winter

        int[] scores = {83, 90, 87};

        //총합
        int sum = 0;
        for (int i=0; i<scores.length; i++) {
            sum += scores[i];
        }

        System.out.println("총합 : " + sum);
        //총합 : 260
        System.out.println("평균: " + sum/(double)scores.length);
        //평균: 86.66666666666667
    }
}
