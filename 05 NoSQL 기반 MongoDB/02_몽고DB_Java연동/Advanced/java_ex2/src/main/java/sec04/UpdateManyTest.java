package sec04;

import app.Database;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.gt;

public class UpdateManyTest {
    public static void main(String[] args) {
        MongoCollection<Document> collection = Database.getCollection("users");

        int age = 16;
        Bson query = gt("age", age);

        Bson updates = Updates.combine(
                // username: "modified name"
                Updates.set("name", "modified name"),
                // lastUpdated: 실행된 실제 시간
                Updates.currentTimestamp("lastUpdated"));

        UpdateResult result = collection.updateMany(query, updates);
        System.out.println("==> UpdateManyResult : " + result.getModifiedCount());

        Database.close();
    }
}
