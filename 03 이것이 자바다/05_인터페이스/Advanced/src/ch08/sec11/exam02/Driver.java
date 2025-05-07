package ch08.sec11.exam02;

public class Driver {
    //매개변수를 인터페이스 타입으로 선언 -> 구현객체 대입 가능
    void drive(Vehicle vehicle) {
        //인터페이스 메서드 호출
        vehicle.run();
    }
}
