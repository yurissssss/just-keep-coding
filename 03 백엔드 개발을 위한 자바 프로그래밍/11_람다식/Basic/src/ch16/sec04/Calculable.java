package ch16.sec04;

@FunctionalInterface
public interface Calculable {
    //리턴값이 있는 추상 메서드
    double calc(double x, double y);
}
