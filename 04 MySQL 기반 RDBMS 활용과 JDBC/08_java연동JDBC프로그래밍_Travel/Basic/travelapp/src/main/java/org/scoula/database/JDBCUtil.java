package org.scoula.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

    // 1. 드라이버 설정, 2. db연결 이용해서 연결하는 것까지.
    // --> Connection con; <--- con을 리턴!
    static Connection conn = null;

    // 연결이 안 돼서 주소가 들어가지 않았으면 conn = null
    public static Connection getConnection() {

        if(conn != null)
            return conn;

        try {
            Properties properties = new Properties();
            properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
            String driver = properties.getProperty("driver");
            String url = properties.getProperty("url");
            String id = properties.getProperty("id");
            String password = properties.getProperty("password");

            Class.forName(driver);
            conn = DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public static void close() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}