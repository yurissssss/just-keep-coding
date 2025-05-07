package ch12.sec08;

import java.text.*;
import java.util.*;

public class DateExample {
    public static void main(String[] args) {
        Date now = new Date();
        //날짜 - 기본 형식
        String strNow1 = now.toString();
        System.out.println(strNow1);

        //날짜 - 포맷 지정 ("년-월-일 시:분:초)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);
    }
}
