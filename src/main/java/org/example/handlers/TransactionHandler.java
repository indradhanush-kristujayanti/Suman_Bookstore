package org.example.handlers;

import com.google.gson.Gson;
import org.example.services.TransactionService;
import spark.Request;
import spark.Response;

public class TransactionHandler {

    private final TransactionService transactionService;
    private final Gson gson = new Gson();

    public TransactionHandler(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public Object recordTransaction(Request request, Response response) {
        transactionService.recordTransaction(request.body());
        response.status(201); // Created
        return "Transaction recorded successfully";
    }
}
