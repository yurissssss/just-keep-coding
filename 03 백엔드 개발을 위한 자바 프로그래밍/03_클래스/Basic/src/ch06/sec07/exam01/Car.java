package ch06.sec07.exam01;

public class Car {
    //필드 선언
    String model;
    String color;
    int maxSpeed;

    //생성자 선언
    //매개변수 통해 어떤 부품을 사용할 것인지 선언
    Car(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        //System.out.println(model);
        //System.out.println(color);
        //System.out.println(maxSpeed);
    }
}
