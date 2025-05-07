package ch13.ch13.sec02.exam02;

public class GenericExample {
    public static void main(String[] args) {

        //이해
        //"나는 부동산 중개소(HomeAgency)에 가서 집(Home)을 빌린다.
        //그 집에는 불을 켜는 기능(turnOnLight)이 있다."

        //HomeAgency homeAgency = new HomeAgency();  // 부동산 중개소 객체 생성
        // -> rent() 메서드 가지고 있음
        // -> Home 객체 리턴

        //Home home = homeAgency.rent();  // 집을 빌린다
        // -> homeAgency.rent() 호출 -> new Home() 리턴
        // --> Home 타입 객체가 home 변수에 들어감
        // public Home rent() {
        //     return new Home(); // 실제로 이렇게 동작
        // }

        //home.turnOnLight();  // 그 집의 불을 켠다

        HomeAgency homeAgency = new HomeAgency();
        //HomeAgency가 Home 객체 빌려줌
        Home home = homeAgency.rent();  //rent(): Home 객체 반환
        //turnOnLight(): Home 클래스 내부에 정의된 메서드
        home.turnOnLight();

        CarAgency carAgency = new CarAgency();
        //CarAgency가 Home 객체 빌려줌
        Car car = carAgency.rent();  //rent(): Car 객체 반환
        //run(): Car 클래스 내부에 정의된 메서드
        car.run();
    }
}


/**
 * public interface Rentable<P> {
 *     P rent();  //타입 파라미터 P를 리턴 타입으로 사용
 * }
 */

/**
 * public class Home {
 *     public void turnOnLight() {
 *         System.out.println("전등을 켭니다.");
 *     }
 * }
 */

/**
 * public class Car {
 *     public void run() {
 *         System.out.println("자동차가 달립니다.");
 *     }
 * }
 */

/**
 *     public Home rent() {
 *         return new Home();  //Home 객체 리턴
 *     }
 */

/**
 *     @Override
 *     public Car rent() {
 *         return new Car();  //Car 객체 리턴
 *     }
 */