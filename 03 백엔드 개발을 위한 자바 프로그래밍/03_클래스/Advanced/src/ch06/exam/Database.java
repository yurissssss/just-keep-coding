package ch06.exam;

import javax.xml.crypto.Data;

//Database 클래스를 싱글톤 패턴으로 설계
// -> 오직 하나의 데이터베이스 연결만 유지
//싱글톤 패턴 - 인스턴스를 오직 하나만 만들고, 여러 곳에서 공유
public class Database {
    //데이터베이스 종류
    private String connection = "MySQL";

    //static(필드) - Database 객체를 단 한 번만 생성
    private static Database database = new Database();

    //private(생성자) - 외부에서 Database() 직접 생성 못하게 막음
    private Database() {}

    //(외부) 인스턴스를 가져오기 위해 사용하는 메서드
    public static Database getInstance() {
        return database;
    }

    //데이터베이스 연결 메서드
    public String connect() {
        System.out.println(connection + "에 연결합니다.");
        return connection;
    }

    //데이터베이스 연결 종료 메서드
    public void close() {
        System.out.println(connection + "을 닫습니다.");
    }

    //메서드 추가
    public String getConnection() {
        return connection;
    }
}
