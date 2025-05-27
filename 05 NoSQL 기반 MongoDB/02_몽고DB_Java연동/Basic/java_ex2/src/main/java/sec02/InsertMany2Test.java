package sec02;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertManyResult;

import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InsertMany2Test {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        List<Document> insertList = new ArrayList<>();
        // i는 10에서 20 사이의 값
        for (int i = 10; i < 21; i++) {
            Document document = new Document();
            // name: user_i
            document.append("name", "user_" + i);
            // age: i
            document.append("age", i);
            // created: 실제 실행된 시간
            document.append("created", new Date());
            insertList.add(document);
        }
        InsertManyResult result = collection.insertMany(insertList);
        System.out.println("==> InsertManyResult : " + result.getInsertedIds());
        Database.close();
    }
}
