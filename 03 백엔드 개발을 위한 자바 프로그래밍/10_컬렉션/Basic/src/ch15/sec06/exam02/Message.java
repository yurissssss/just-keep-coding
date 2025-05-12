package ch15.sec06.exam02;

public class Message {
    public String command;
    public String to;

    //전체 매개변수 생성자 - 롬복 / Generator 이용
    public Message(String command, String to) {
        this.command = command;
        this.to = to;
    }
}
