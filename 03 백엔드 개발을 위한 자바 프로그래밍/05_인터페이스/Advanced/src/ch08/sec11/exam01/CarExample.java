package ch08.sec11.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();

        //타이어 객체 교체
        myCar.tire1 = new KumhoTire();
        myCar.tire2 = new KumhoTire();

        //run() 메서드 실행 (다형성: 실행 결과가 다름)
        myCar.run();
    }
}
