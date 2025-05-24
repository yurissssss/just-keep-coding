package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

// 테스트 순서는 어노테이션으로 지정함을 설정
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    //JDBCUtil을 이용하여 Connection 객체를 멤버 변수로 정의
    Connection conn = JDBCUtil.getConnection();

    // 하나의 단위 테스트가 끝날 때마다 Connection을 닫는 tearDown() 메서드 정의
    @AfterAll
    static void tearDown() {
        JDBCUtil.close();
    }

    // 테스트 순서 1번
    @Test
    @DisplayName("새로운 user를 등록한다.")
    @Order(1)
    public void insertUser() throws SQLException {
        String sql = "insert into user (id, password, name, role) values (?, ?, ?, ?)";

        //PreparedStatement를 이용하여 users 테이블에 데이터 추가
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");

            int count = pstmt.executeUpdate();
            // insert 작업의 성공 여부를 단정문으로 확인
            // assert: ~하길 기대한다
            Assertions.assertEquals(1, count);
        }
    }

    // 테스트 순서 2번
    @Test
    @DisplayName("user 목록을 추출한다.")
    @Order(2)
    public void selectUser() throws SQLException {
        String sql = "select * from users";

        // Statement를 이용하여 users 테이블의 모든 데이터 추출
        // ResultSet을 이용하여 추출한 모든 행의 name 컬럼 출력
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
        }
    }

    // 테스트 순서 3번
    @Test
    @DisplayName("특정 user를 검색한다.")
    @Order(3)
    public void selectUserById() throws SQLException {
        String userId = "scoula";
        String sql = "select * from users where id = ?";

        // PreparedStatement를 이용하여 users 테이블에서 id를 이용하여 한 개의 데이터 추출
        // ResultSet을 이용하여 추출한 행의 name 컬럼 출력
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(rs.getString("name"));
                } else {
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    // 테스트 순서 4번
    @Test
    @DisplayName("특정 user 수정한다.")
    @Order(4)
    public void updateUser() throws SQLException {
        String userid = "scoula";
        String sql = "update users set name = ?, where id = ?";

        // PreparedStatement를 이용하여 users 테이블에서 지정한 id의 name 수정
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "스콜라 수정");
            stmt.setString(2, userid);

            int count = stmt.executeUpdate();
            // 단정문을 이용하여 update문 실행 성공 여부 판정
            Assertions.assertEquals(1, count);
        }
    }

    // 테스트 순서 5번
    @Test
    @DisplayName("특정 user 수정한다.")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        String sql = "delete from users where id = ?";

        // PreparedStatement를 이용하여 users 테이블에서 지정한 id의 행 삭제
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, userid);

            int count = stmt.executeUpdate();
            // 단정문을 이용하여 delete문 실행 성공 여부 판정
            Assertions.assertEquals(1, count);
        }
    }
}
