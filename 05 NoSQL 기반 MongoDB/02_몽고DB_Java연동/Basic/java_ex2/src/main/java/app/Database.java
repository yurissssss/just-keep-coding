package app;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {
    static MongoClient client;
    static MongoDatabase database;

    static {
        // 데이터베이스 연결 및 database 참조 설정
        ConnectionString connectionString = new ConnectionString("mongodb://127.0.0.1:27017");
        client = MongoClients.create(connectionString);
        database = client.getDatabase("todo_db");
    }

    public static void close() {
        // 데이터베이스 얻기
        client.close();
    }

    public static MongoDatabase getDatabase() {
        // 데이터베이스 참조 얻기
        return database;
    }

    public static MongoCollection<Document> getCollection(String colName) {
        // 전달된 컬렉션이름의 컬렉션 리턴하기
        MongoCollection<Document> collection = database.getCollection(colName);
        return collection;
    }
}