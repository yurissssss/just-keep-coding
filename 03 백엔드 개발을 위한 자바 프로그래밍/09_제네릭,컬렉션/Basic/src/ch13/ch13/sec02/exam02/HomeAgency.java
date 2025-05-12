package ch13.ch13.sec02.exam02;

//Rentable<P> 구현 - P타입을 'Home'으로 고정
public class HomeAgency implements Rentable<Home> {
    //인터페이스에서 요구하는 rent() 메서드를 'Home'타입으로 구현
    @Override
    public Home rent() {
        return new Home();  //Home 객체 리턴
    }
}


/**
 * public interface Rentable<P> {
 *     P rent();  //타입 파라미터 P를 리턴 타입으로 사용
 * }
 */