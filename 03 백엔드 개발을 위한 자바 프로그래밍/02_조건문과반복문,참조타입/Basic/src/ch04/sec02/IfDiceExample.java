package ch04.sec02;

public class IfDiceExample {
    public static void main(String[] args) {
        //0.0 <= Math.random() < 1.0
        //0.0 <= Math.random()*6 < 6.0
        //0 <= (int)(Math.random()*6) < 6
        //1 <= (int)(Math.random()*6)+1 < 7
        int num = (int)(Math.random()*6) + 1;  //1-6

        if (num == 1) {
            System.out.println("1번이 나왔습니다.");
        } else if (num == 2) {
            System.out.println("2번이 나왔습니다.");
        } else if (num == 3) {
            System.out.println("3번이 나왔습니다.");
        } else if (num == 4) {
            System.out.println("4번이 나왔습니다.");
        } else if (num == 5) {
            System.out.println("5번이 나왔습니다.");
        } else {
            System.out.println("6번이 나왔습니다.");
        }
    }
}
