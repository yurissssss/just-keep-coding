package ch15.sec06.exam01;

public class Coin {
    private int value;

    //전체 매개변수 생성자
    public Coin(int value) {
        this.value = value;
    }

    //value에 대한 Getter - 롬복 / Generator 이용
    public int getValue() {
        return value;
    }
}
