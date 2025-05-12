package ch15.sec06.exam01;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        //Stack 컬렉션 생성
        //Stack<Coin> coinBox = new Stack<Coin>();
        Stack<Coin> coinBox = new Stack<Coin>();
        
        //동전 넣기
        //100 -> 50 -> 500 -> 10
        coinBox.push(new Coin(100));
        coinBox.push(new Coin(50));
        coinBox.push(new Coin(500));
        coinBox.push(new Coin(10));
        
        //동전을 하나씩 꺼내기
        //LIFO: 나중에 넣은 것부터 꺼냄
        //10 -> 500 -> 50 -> 100
        while (!coinBox.isEmpty()) {
            Coin coin = coinBox.pop();  //맨 위 동전 꺼냄 (LIFO)
            System.out.println("꺼내온 동전: " + coin.getValue() + "원");
        }
    }
}
