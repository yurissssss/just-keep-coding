package ch07.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;

        parent.method1();
        parent.method2();
        //오버라이딩된 child.method2() 호출
        //parent.method3();
        //호출 불가능 <- method3()는 Child class의 메서드
        //실제 객체는 child지만, 참조타입이 Parent
        // --> Parent class의 메서드만 접근가능!
    }
}
