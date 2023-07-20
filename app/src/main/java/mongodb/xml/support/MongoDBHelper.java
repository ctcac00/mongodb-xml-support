package mongodb.xml.support;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.InsertOneResult;

import org.bson.BsonObjectId;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.mongodb.client.model.Filters.eq;

public class MongoDBHelper {

  private static final Logger logger = LoggerFactory.getLogger(MongoDBHelper.class);

  private MongoClient mongoClient;

  public MongoDBHelper(String uri) {
    mongoClient = MongoClients.create(uri);
  }

  public BsonObjectId insertDocument(String dbName, String collectionName,
      Document document) {
    try {
      MongoDatabase database = mongoClient.getDatabase(dbName);
      MongoCollection<Document> collection = database.getCollection(collectionName);
      InsertOneResult result = collection.insertOne(document);
      logger.info("Document inserted sucessfully.");
      return result.getInsertedId().asObjectId();
    } catch (Exception e) {
      e.printStackTrace();
      return new BsonObjectId();
    }
  }

  public Document findDocument(String dbName, String collectionName,
      BsonObjectId _id) {
    try {
      MongoDatabase database = mongoClient.getDatabase(dbName);
      MongoCollection<Document> collection = database.getCollection(collectionName);

      Bson filter = eq("_id", _id);
      Document doc = collection.find(filter).first();
      return doc;
    } catch (Exception e) {
      e.printStackTrace();
      return new Document();
    }
  }
}
