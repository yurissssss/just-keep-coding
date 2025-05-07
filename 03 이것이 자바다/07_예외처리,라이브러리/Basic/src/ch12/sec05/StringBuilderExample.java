package ch12.sec05;

public class StringBuilderExample {
    public static void main(String[] args) {
        String data = new StringBuilder()
                .append("DEF")  //DEF  //문자열을 끝에 추가
                .insert(0, "ABC")  //ABCDEF  //문자열을 지정 위치(index0)에 추가
                .delete(3, 4)  //ABCEF  //문자열 일부(index3 이상 index4 미만)를 삭제
                .toString();
        System.out.println(data);
        //ABCEF
    }
}
