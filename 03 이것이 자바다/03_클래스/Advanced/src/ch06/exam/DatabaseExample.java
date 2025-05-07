package ch06.exam;

import javax.xml.crypto.Data;

public class DatabaseExample {
    public static void main(String[] args) {
        Database database = Database.getInstance();

        //데이터베이스 연결
        database.connect();  //MySQL에 연결합니다.
        //데이터베이스 이름 출격
        System.out.println("데이터베이스: " + database.getConnection());
        //데이터베이스: MySQL
        //데이터베이스 연결 종료
        database.close();  //MySQL을 닫습니다.
    }
}
