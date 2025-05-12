package ch11.sec06;

//사용자 정의 예외 클래스 (잔고 부족 예외)
// -> 개발자가 직접 예외 클래스를 정의해서 만든 자신만의 의미 있는 예외
//Exception: 일반 예외
// + RuntimeException: 비정상적인 실행예외
public class InsufficientException extends Exception {
    //기본 생성자 - 예외 메시지 없이 그냥 던짐
    public InsufficientException() {
    }
    //예외 메시지와 함께 던짐
    public InsufficientException(String message) {
        super(message);  //Exception 클래스에 메시지 던짐
    }
}
