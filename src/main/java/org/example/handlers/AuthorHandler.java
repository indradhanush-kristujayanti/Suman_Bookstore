package org.example.handlers;

import com.google.gson.Gson;
import org.example.services.AuthorService;
import spark.Request;
import spark.Response;

public class AuthorHandler {

    private final AuthorService authorService;
    private final Gson gson = new Gson();

    public AuthorHandler(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Object addAuthor(Request request, Response response) {
        authorService.addAuthor(request.body());
        response.status(201); // Created
        return "Author added successfully";
    }
}
