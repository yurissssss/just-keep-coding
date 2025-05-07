package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        //LinkedList를 큐로 이용
        //Queue 컬렉션 생성
        Queue<Message> messageQueue = new LinkedList<>();

        //Message 인스턴스 추가
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "감자바"));

        //큐가 빌 때까지 큐에서 Message 추출
        while (!messageQueue.isEmpty()) {  //비어 있지 않다면 반복
            Message message = messageQueue.poll();
            switch (message.command) {
                //'break;' 생략가능
                case "sendMail" -> System.out.println(message.to + "님에게 메일을 보냅니다.");
                //홍길동님에게 메일을 보냅니다.
                case "sendSMS" -> System.out.println(message.to + "님에게 SMS를 보냅니다.");
                //신용권님에게 SMS를 보냅니다.
                case "sendKakaotalk" -> System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
                //감자바님에게 카카오톡을 보냅니다.
            }
        }
    }
}
