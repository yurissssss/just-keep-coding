package ch04.sec07;

public class BreakExample {
    public static void main(String[] args) {
        while (true) {
            int num = (int)(Math.random()*6) +1;  //1-6
            System.out.println(num);
            //6이 나오면 프로그램 종료
            if (num == 6) {
                System.out.println("프로그램 종료");
                break;
            }
        }
    }
}
