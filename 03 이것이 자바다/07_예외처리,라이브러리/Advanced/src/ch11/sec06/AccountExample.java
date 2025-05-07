package ch11.sec06;

public class AccountExample {
    public static void main(String[] args) {
        Account account = new Account();
        //balance = 0 (기본값)

        account.deposit(100);  //예금
        System.out.println("예금액: " + account.getBalance());
        //예금액: 100

        //예외 발생 -> 예외 처리 코드 + withdraw() 메서드 호출
        try {
            account.withdraw(30000);  //출금
        } catch (InsufficientException e) {
            String message = e.getMessage();
            System.out.println(message);
            //잔고 부족: 29900 모자람
        }
    }
}
