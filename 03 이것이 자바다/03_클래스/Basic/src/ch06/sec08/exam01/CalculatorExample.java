package ch06.sec08.exam01;

public class CalculatorExample {
    public static void main(String[] args) {
        //Calculator 객체 생성
        Calculator myCalc = new Calculator();

        //리턴값이 없는 powerOn() 메소드 호출
        myCalc.powerOn();
        //전원을 켭니다.

        int result1 = myCalc.plus(5, 6);
        System.out.println("result1: " + result1);
        //result1: 11

        int x = 10;
        int y = 4;
        double result2 = myCalc.divide(x, y);
        System.out.println("result2: " + result2);
        //result2: 2.5

        //리턴값이 없는 poweroff() 메소드 호출
        myCalc.powerOff();
        //전원을 끕니다.
    }
}
