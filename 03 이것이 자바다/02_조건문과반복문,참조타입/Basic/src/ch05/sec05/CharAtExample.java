package ch05.sec05;

public class CharAtExample {
    public static void main(String[] args) {
        String ssn = "9506241230123";
        char gender = ssn.charAt(6);

        switch (gender) {
            //1,3인 경우
            case '1','3' -> System.out.println("남자입니다");
            //남자입니다

            //이 외의 경우 (2,4)
            default -> System.out.println("여자입니다.");
        }
    }
}
