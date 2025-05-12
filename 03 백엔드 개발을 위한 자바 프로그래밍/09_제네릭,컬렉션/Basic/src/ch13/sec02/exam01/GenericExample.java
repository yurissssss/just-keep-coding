package ch13.sec02.exam01;

public class GenericExample {
    public static void main(String[] args) {
        //K -> Tv, M -> String
        //private Tv kind;
        //private String model;
        Product<Tv, String> product1 = new Product<>();
        product1.setKind(new Tv());  //Tv 타입 객체
        product1.setModel("스마트Tv");  //String 타입 객체

        //제네릭 -> 형변환 없이 타입 자동으로 맞춰짐
        //getKind(): Tv 타입 리턴 -> tv(변수)에 저장
        Tv tv = product1.getKind();
        //getModel(): String 타입 리턴 -> model(변수)에 저장
        String model = product1.getModel();

        Product<Car, String> product2 = new Product<>();
        product2.setKind(new Car());  //Car 타입 객체
        product2.setModel("SUV자동차");  //String 타입 객체

        //getKind(): Car 타입 리턴 -> car(변수)에 저장
        Car car = product2.getKind();
        //getModel(): String 타입 리턴 -> carModel(변수)에 저장
        String carModel = product2.getModel();
    }
}
