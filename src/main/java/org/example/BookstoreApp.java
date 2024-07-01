package org.example;

import com.google.gson.Gson;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.example.handlers.AuthorHandler;
import org.example.handlers.InventoryHandler;
import org.example.handlers.TransactionHandler;
import org.example.services.AuthorService;
import org.example.services.InventoryService;
import org.example.services.TransactionService;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class BookstoreApp {

    private static final MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    private static final MongoDatabase database = mongoClient.getDatabase("bookstore");
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        port(4567); // Set the port number

        // Initialize services
        InventoryService inventoryService = new InventoryService(database);
        TransactionService transactionService = new TransactionService(database);
        AuthorService authorService = new AuthorService(database);

        // Initialize handlers with services
        InventoryHandler inventoryHandler = new InventoryHandler(inventoryService);
        TransactionHandler transactionHandler = new TransactionHandler(transactionService);
        AuthorHandler authorHandler = new AuthorHandler(authorService);

        // Endpoints for Inventory CRUD operations
        post("/inventory", inventoryHandler::addBook, gson::toJson);

        // Endpoints for Transactions CRUD operations
        post("/transactions", transactionHandler::recordTransaction, gson::toJson);

        // Endpoints for Authors CRUD operations
        post("/authors", authorHandler::addAuthor, gson::toJson);
    }
}
