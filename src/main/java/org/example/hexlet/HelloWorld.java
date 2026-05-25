package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        
        // Существующие обработчики
        app.get("/", ctx -> ctx.result("Hello World"));
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.get("/about", ctx -> ctx.result("О нас"));
        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class)
                                .getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });
        
        // НОВЫЙ ОБРАБОТЧИК с множественными параметрами
        app.get("/users/{id}/post/{postId}", ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + ", Post ID: " + postId);
        });
        
        app.start(7070);
    }
}
