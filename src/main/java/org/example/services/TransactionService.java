package org.example.services;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class TransactionService {

    private final MongoCollection<Document> transactionsCollection;

    public TransactionService(MongoDatabase database) {
        this.transactionsCollection = database.getCollection("transactions");
    }

    public void recordTransaction(String transactionJson) {
        Document transactionDocument = Document.parse(transactionJson);
        transactionsCollection.insertOne(transactionDocument);
    }
}
