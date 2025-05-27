package sec05;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.DeleteResult;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.gt;

public class DeleteManyTest {
    public static <Document> void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        // age > 15인 문서 모두 삭제
        int age = 15;
        Bson query = gt("age", age);

        DeleteResult result = collection.deleteMany(query);
        System.out.println("==> DeleteManyResult : " + result.getDeletedCount());

        Database.close();
    }
}
