package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Connection {

    public static void main(String[] args) {
        //String connectionString = System.getProperty("mongodb.uri");
        String connectionString = "mongodb+srv://myAtlasDBUser:myatlas-001@myatlasclusteredu.q9bg9.mongodb.net/?retryWrites=true&w=majority&appName=myAtlasClusterEDU";
        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
            databases.forEach(db -> System.out.println(db.toJson()));
            mongoClient.close();
        }
    }
}


//./mvnw compile exec:java -Dexec.mainClass="com.mongodb.quickstart.Connection" -Dmongodb.uri="mongodb+srv://myAtlasDBUser:myatlas-001@myatlasclusteredu.q9bg9.mongodb.net/?retryWrites=true&w=majority&appName=myAtlasClusterEDU"
