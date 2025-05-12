package ch07.sec03.exam02;

public class SmartPhoneExample {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("갤럭시", "은색");
        //Phone(String model, String color) 생성자 실행
        //SmartPhone(String model, String color) 생성자 실행됨

        System.out.println("모델: " + myPhone.model);
        //모델: 갤럭시
        System.out.println("색상: " + myPhone.color);
        //색상: 은색
    }
}
