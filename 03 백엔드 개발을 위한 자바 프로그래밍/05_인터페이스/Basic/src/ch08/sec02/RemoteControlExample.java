package ch08.sec02;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;

        //rc변수에 Television 객체 대입
        rc = new Television();
        rc.turnOn();
        //TV를 컵니다.

        //rc 변수에 Audio 객체 대입 (교체시킴)
        rc = new Audio();
        rc.turnOn();
        //Audio를 켭니다.
    }
}
