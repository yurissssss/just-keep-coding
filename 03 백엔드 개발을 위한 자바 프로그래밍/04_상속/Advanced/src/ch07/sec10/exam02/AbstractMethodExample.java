package ch07.sec10.exam02;

public class AbstractMethodExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        //매개변수의 다형성
        //자동 형변환
        animalSound(new Dog());
        animalSound(new Cat());
    }

    public static void animalSound(Animal animal) {
        //재정의된 메서드 호출
        animal.sound();
    }
}

/**
 * 멍멍
 * 야옹
 * 멍멍
 * 야옹
 */