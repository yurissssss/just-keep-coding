package ch13.ch13.sec02.exam02;

//Rentable<P> 구현 - P타입을 'Car'로 고정
public class CarAgency implements Rentable<Car> {
    //인터페이스에서 요구하는 rent() 메서드를 'Car'타입으로 구현
    @Override
    public Car rent() {
        return new Car();  //Car 객체 리턴
    }
}


/**
 * public interface Rentable<P> {
 *     P rent();  //타입 파라미터 P를 리턴 타입으로 사용
 * }
 */