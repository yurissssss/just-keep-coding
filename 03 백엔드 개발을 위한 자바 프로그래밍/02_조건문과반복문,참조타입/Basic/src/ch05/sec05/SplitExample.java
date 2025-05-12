package ch05.sec05;

public class SplitExample {
    public static void main(String[] args) {
        String board = "1,자바 학습,참조 타입 String을 학습합니다.,홍길동";

        //',' 기준으로 문자열 분리
        String[] tokens = board.split(",");

        //인덱스별로 읽기
        System.out.println("번호: " + tokens[0]);
        //번호: 1
        System.out.println("제목: " + tokens[1]);
        //제목: 자바 학습
        System.out.println("내용: " + tokens[2]);
        //내용: 참조 타입 String을 학습합니다.
        System.out.println("성명: " + tokens[3]);
        //성명: 홍길동

        System.out.println();

        //for문을 이용하여 읽기
        for(int i=0; i<tokens.length; i++) {
            System.out.println(tokens[i]);
        }

    }
}
