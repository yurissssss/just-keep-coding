package ch03;

public class Trapezoid {
    public static void main(String[] args) {
        int lengthTop = 5;
        int lengthBottom = 10;
        int height = 7;
        //double area = (double)(lengthTop + lengthBottom) * height / 2;
        //double area = (lengthTop + lengthBottom) * height * 1.0 / 2;
        double area = (lengthTop + lengthBottom) * height / 2.0;

        System.out.println("주어진 사다리꼴의 넓이는: "+ area);
        //주어진 사다리꼴의 넓이는: 52.5
    }
}
