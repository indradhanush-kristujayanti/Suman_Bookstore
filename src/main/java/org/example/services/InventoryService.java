package org.example.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class InventoryService {

    private final MongoCollection<Document> inventoryCollection;

    public InventoryService(MongoDatabase database) {
        this.inventoryCollection = database.getCollection("inventory");
    }

    public void addBook(String bookJson) {
        Document bookDocument = Document.parse(bookJson);
        inventoryCollection.insertOne(bookDocument);
    }
}
