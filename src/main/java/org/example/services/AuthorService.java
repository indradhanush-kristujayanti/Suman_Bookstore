package org.example.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class AuthorService {

    private final MongoCollection<Document> authorsCollection;

    public AuthorService(MongoDatabase database) {
        this.authorsCollection = database.getCollection("authors");
    }

    public void addAuthor(String authorJson) {
        Document authorDocument = Document.parse(authorJson);
        authorsCollection.insertOne(authorDocument);
    }
}
