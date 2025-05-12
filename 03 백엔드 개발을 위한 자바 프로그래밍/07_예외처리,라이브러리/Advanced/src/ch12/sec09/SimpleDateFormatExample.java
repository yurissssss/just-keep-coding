package ch12.sec09;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatExample {
    public static void main(String[] args) {
        Date now = new Date();

        //SimpleDateFormat: Date를 문자열(String)로 바꿔줌
        //-> 출력용으로 주로 사용
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(now));
        //2025-04-24

        sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
        System.out.println(sdf.format(now));
        //2025년 04월 24일

        sdf = new SimpleDateFormat("yyyy.MM.dd a HH:mm:ss");
        System.out.println(sdf.format(now));
        //2025.04.24 오후 18:44:39

        sdf = new SimpleDateFormat("오늘은 E요일");
        System.out.println(sdf.format(now));
        //오늘은 목요일

        sdf = new SimpleDateFormat("올해의 D번째 날");
        System.out.println(sdf.format(now));
        //올해의 114번째 날

        sdf = new SimpleDateFormat("이달의 d번째 날");
        System.out.println(sdf.format(now));
        //이달의 24번째 날
    }
}
