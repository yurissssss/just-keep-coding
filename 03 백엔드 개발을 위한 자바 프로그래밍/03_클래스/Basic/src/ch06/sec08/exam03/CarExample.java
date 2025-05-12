package ch06.sec08.exam03;

public class CarExample {
    public static void main(String[] args) {
        //Car 객체 생성
        Car myCar = new Car();

        //리턴값이 없는 setGas() 메솓 호출
        myCar.setGas(5);

        //isLeftGas() 메소드를 호출해서 받은 리턴값이 true일 경우 if 블록 실행
        if (myCar.isLeftGas()) {
            //gas가 있습니다.

            System.out.println("출발합니다.");
            //출발합니다.

            //리턴값이 없는 run() 메소드 호출
            myCar.run();
            //달립니다.(gas잔량: 5)
        }
        System.out.println("gas를 주입하세요.");
        //gas를 주입하세요.
    }
}
