package ch12.sec08;

import java.util.*;

public class CalendarExample {
    public static void main(String[] args) {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;  //MONTH는 0부터 시작 (0->1월, 1->2월)
        int day = now.get(Calendar.DAY_OF_MONTH);
        int week = now.get(Calendar.DAY_OF_WEEK);  //1(일요일) ~ 7(토요일)
        String strWeek = null;

        System.out.println(week);

        //Calendar.MONDAY: JAVA가 내부적으로 정의해둔 static final 상수
        //public static final int MONDAY = 2;
        //숫자 대신 의미 있는 이름 쓰는 게 가독성 높음!
        switch (week) {
            case Calendar.MONDAY: strWeek = "월"; break;
            case Calendar.TUESDAY: strWeek = "화"; break;
            case Calendar.WEDNESDAY: strWeek = "수"; break;
            case Calendar.THURSDAY: strWeek = "목"; break;
            case Calendar.FRIDAY: strWeek = "금"; break;
            case Calendar.SATURDAY: strWeek = "토"; break;
            default: strWeek = "일"; break;
        }

        int amPm = now.get(Calendar.AM_PM);  //0=AM, 1=PM
        String strAmPm = null;
        if (amPm == Calendar.AM) strAmPm = "오전";
        else strAmPm = "오후";

        int hour = now.get(Calendar.HOUR);  //12시간 기준: 0~11시
        //int hour = now.get(Calendar.HOUR_OF_DAY);  //24시간 기준: 0~23시
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        System.out.print(year + "년 ");
        System.out.print(month + "월 ");
        System.out.println(day + "일 ");
        System.out.print(strWeek + "요일 ");
        System.out.println(strAmPm + " ");
        System.out.print(hour + "시 ");
        System.out.print(minute + "분 ");
        System.out.println(second + "초 ");
    }
}
