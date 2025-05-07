package ch13.ch13.sec02.exam02;

//타입 파라미터 P
public interface Rentable<P> {
    P rent();  //타입 파라미터 P를 리턴 타입으로 사용
}
