package ch07.sec10.exam02;

public abstract class Animal {
    //메서드 선언
    public void breathe() {
        System.out.println("숨을 쉽니다.");
    }

    //추상 메서드 선언 - 리턴값 X
    public abstract void sound();
}
