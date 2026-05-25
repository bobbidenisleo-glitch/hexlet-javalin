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
        
        // НОВЫЙ ОБРАБОТЧИК для /hello
        app.get("/hello", ctx -> {
            // Получаем параметр name, если нет - используем "World"
            String name = ctx.queryParamAsClass("name", String.class)
                                .getOrDefault("World");
            
            // Возвращаем приветствие
            ctx.result("Hello, " + name + "!");
        });
        
        app.start(7070);
    }
}
