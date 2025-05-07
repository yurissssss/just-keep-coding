package ch16.sec01;

//인터페이스가 함수형 인터페이스임을 보장하기 위해 사용
// -> 컴파일 과정에서 추상 메서드가 하나인지 검사할 때 도와줌
@FunctionalInterface
public interface Calculable {
    //추상 메서드
    //함수형 인터페이스 -> 1개의 추상 메서드만 가질 수 있음
    void calculate(int x, int y);
}
