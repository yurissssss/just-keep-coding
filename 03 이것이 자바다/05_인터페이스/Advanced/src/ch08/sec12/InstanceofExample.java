package ch08.sec12;

public class InstanceofExample {
    public static void main(String[] args) {
        //구현 객체 생성
        Taxi taxi = new Taxi();
        Bus bus = new Bus();

        //ride() 메서드 호출 시 구현 객체 매개값으로 전달.
        ride(taxi);
        System.out.println();
        //택시가 달립니다.
        ride(bus);
    }

    //인터페이스 매개변수를 갖는 메서드
    public static void ride(Vehicle vehicle) {
        //방법 1
        //if(vehicle instanceof Bus) {
        //    Bus bus = (Bus) vehicle;
        //    bus.checkFare();
        //    //승차요금을 체크합니다.
        //}

        //방법 2
        if (vehicle instanceof Bus bus) {
            bus.checkFare();
            //승차요금을 체크합니다.
        }
        //ride 메서드는 매개변수 vehicle이 Bus인 경우에만 실행
        //-> vehicle.run() = Bus.run()
        vehicle.run();
        //버스가 달립니다.
    }
}
