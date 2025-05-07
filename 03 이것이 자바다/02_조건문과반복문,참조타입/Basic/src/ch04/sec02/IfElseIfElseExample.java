package ch04.sec02;

public class IfElseIfElseExample {
    public static void main(String[] args) {
        int score = 75;

        //예외처리 - 100초과 or 0미만
        //if(score>100 || score<0) {
        //    System.out.println("점수는 0~100 사이만 입력가능합니다.");
        //}

        //else if(90<=score && score<=100)
        if(score>=90) {
            System.out.println("점수가 90~100입니다.");
            System.out.println("등급은 A입니다.");
        } else if(80<=score && score<=89) {
            System.out.println("점수가 80~89입니다.");
            System.out.println("등급은 B입니다.");
        } else if(70<=score && score<=79) {
            System.out.println("점수가 70~79입니다.");
            //점수가 70~79입니다.
            System.out.println("등급은 C입니다.");
            //등급은 C입니다.
        }
          //else if(0<=score && score<=69)
          else{
            System.out.println("점수가 0~69입니다.");
            System.out.println("등급은 D입니다.");
        }
    }
}
