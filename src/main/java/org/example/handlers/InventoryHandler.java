package org.example.handlers;

import com.google.gson.Gson;
import org.example.services.InventoryService;
import spark.Request;
import spark.Response;

public class InventoryHandler {

    private final InventoryService inventoryService;
    private final Gson gson = new Gson();

    public InventoryHandler(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public Object addBook(Request request, Response response) {
        inventoryService.addBook(request.body());
        response.status(201); // Created
        return "Book added successfully";
    }
}
