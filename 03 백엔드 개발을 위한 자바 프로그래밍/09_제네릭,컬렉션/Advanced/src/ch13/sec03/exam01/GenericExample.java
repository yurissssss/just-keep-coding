package ch13.sec03.exam01;

public class GenericExample {
    //boxing 제너릭 메서드 정의
    //<T>: 타입 파라미터
    //Box<T>: 리턴타입 - T 타입 값을 Box에 포장 (T를 내용물로 갖는 Box 객체)
    public static <T> Box<T> boxing(T t) {
        Box<T> box = new Box<>();
        box.set(t);
        return box;
    }

    public static void main(String[] args) {
        Box<Integer> box1 = boxing(100);
        int intValue = box1.get();
        System.out.println(intValue);

        Box<String> box2 = boxing("홍길동");
        String strValue = box2.get();
        System.out.println(strValue);
    }
}
