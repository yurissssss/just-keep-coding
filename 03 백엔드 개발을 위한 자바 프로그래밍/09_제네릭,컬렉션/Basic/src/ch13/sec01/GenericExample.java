package ch13.sec01;

public class GenericExample {
    public static void main(String[] args) {
        //Box<String> 타입의 객체 생성
        //Box를 생성할 때 타입 파라미터 'T' 대신 String으로 지정
        // -> Box 클래스의 content 필드는 String 타입
        Box<String> box1 = new Box<>();
        box1.content = "안녕하세요.";
        String str = box1.content;
        System.out.println(str);

        //Box<Integer> 타입의 객체 생성
        Box<Integer> box2 = new Box<>();
        //오토박싱: int -> Integer
        box2.content = 100;
        //오토언박싱: Integer -> int
        int value = box2.content;
        System.out.println(value);
    }
}
