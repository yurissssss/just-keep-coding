package ch08.sec11.exam01;

public class Car {
    //Tire타입의 멤버 변수 정의
    Tire tire1= new HankookTire();
    Tire tire2= new HankookTire();

    //기본값으로 HankookTire 인스턴스로 정의
    void run() {
        //run()메서드에서 각 멤버 변수의 roll() 메서드 호출
        tire1.roll();
        tire2.roll();
    }
}
