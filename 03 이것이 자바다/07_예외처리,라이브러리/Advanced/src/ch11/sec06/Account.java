package ch11.sec06;

public class Account {
    //private -> 직접 접근X, getter/setter 메서드를 통해 접근O
    private long balance;

    public long getBalance() {
        return balance;
    }

    //입금
    public void deposit(int money) {
        balance += money;
    }

    //출금
    public void withdraw(int money) throws InsufficientException {
        //잔액보다 출금액이 크면
        if (balance < money) {
            //사용자 정의 예외 발생 -> 예외 객체 생성과 동시에 메시지 전달
            throw new InsufficientException("잔고 부족: " + (money-balance) + " 모자람");
        }
        balance -= money;
    }
}
