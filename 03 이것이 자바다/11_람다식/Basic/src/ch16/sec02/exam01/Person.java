package ch16.sec02.exam01;

public class Person {
    //action 메서드
    //매개변수로 받은 Workable 인터페이스의 work() 메서드 호출
    public void action(Workable workable) {
        workable.work();
    }
}
