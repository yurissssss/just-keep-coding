package ch16.sec01;

public class LambdaExample {
    public static void main(String[] args) {
        //Calculable 인터페이스의 calculate 메서드를 구현한 익명 함수
        //calculate 메서드 없이 action을 바로 호출하면?
        // -> 새로운 연산을 추가할 때마다 action 메서드 내부를 수정해야 함

        //x + y 계산
        action((x, y) -> {
            int result = x + y;
            System.out.println("result: " + result);
        });

        //x - y 계산
        action((x, y) -> {
            int result = x - y;
            System.out.println("result: " + result);
        });
    }

    public static void action(Calculable calculable) {
        //데이터
        int x = 10;
        int y = 4;
        //데이터 처리
        calculable.calculate(x, y);
    }
}
