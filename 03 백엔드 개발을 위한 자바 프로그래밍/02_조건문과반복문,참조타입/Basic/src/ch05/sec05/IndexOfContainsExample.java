package ch05.sec05;

public class IndexOfContainsExample {
    public static void main(String[] args) {
        String subject = "자바 프로그래밍";

        //"프로그래밍"이 있는 위치
        int index = subject.indexOf("프로그래밍");
        System.out.println(index);
        //3

        boolean result = subject.contains("자바");
        if(result) {
            System.out.println("자바와 관련된 책이군요.");
            //자바와 관련된 책이군요.
        } else {
            System.out.println("자바와 관련이 없는 책이군요.");
        }

//        index = subject.indexOf("자바");
//        if (index == -1) {
//            System.out.println("자바와 관련이 없는 책이군요.");
//        } else {
//            System.out.println("자바와 관련된 책이군요.");
//            //자바와 관련된 책이군요.
//        }
    }
}
