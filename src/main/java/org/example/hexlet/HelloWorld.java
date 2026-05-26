package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.http.NotFoundResponse;
import static io.javalin.rendering.template.TemplateUtil.model;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;

import java.nio.file.Path;
import java.util.List;

public final class HelloWorld {

    public static void main(String[] args) {
        var sourceDir = Path.of("src/main/jte");
        var targetDir = Path.of("jte-classes");
        var codeResolver = new DirectoryCodeResolver(sourceDir);
        var templateEngine = TemplateEngine.create(codeResolver, targetDir, ContentType.Html);

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte(templateEngine));
        });

        // Главная страница
        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        // ========== РАБОТА С ПОЛЬЗОВАТЕЛЯМИ ==========
        
        // Форма создания пользователя
        app.get("/users/build", ctx -> {
            ctx.render("users/build.jte");
        });

        // Обработчик создания пользователя (POST)
        app.post("/users", ctx -> {
            String name = ctx.formParam("name");
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");
            String passwordConfirmation = ctx.formParam("passwordConfirmation");

            // Нормализация
            if (name != null) {
                name = name.trim();
            }
            if (email != null) {
                email = email.trim().toLowerCase();
            }

            // Валидация
            if (name == null || name.isEmpty()) {
                ctx.status(400).result("Имя обязательно");
                return;
            }
            if (email == null || email.isEmpty()) {
                ctx.status(400).result("Email обязателен");
                return;
            }
            if (password == null || !password.equals(passwordConfirmation)) {
                ctx.status(400).result("Пароли не совпадают");
                return;
            }

            User user = new User(name, email, password);
            UserRepository.save(user);

            ctx.redirect("/users");
        });

        // Список пользователей (с фильтрацией)
        app.get("/users", ctx -> {
            String term = ctx.queryParam("term");
            
            List<User> users = UserRepository.getEntities();
            
            if (term != null && !term.isEmpty()) {
                users = users.stream()
                    .filter(user -> user.getName().toLowerCase().startsWith(term.toLowerCase()))
                    .toList();
            }
            
            UsersPage page = new UsersPage(users, term);
            ctx.render("users/index.jte", model("page", page));
        });

        // Просмотр одного пользователя
        app.get("/users/{id}", ctx -> {
            Long id = Long.parseLong(ctx.pathParam("id"));
            User user = UserRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("User not found"));
            
            UserPage page = new UserPage(user);
            ctx.render("users/show.jte", model("page", page));
        });

        // ========== СТАРЫЕ МАРШРУТЫ (можно удалить или оставить) ==========
        app.get("/about", ctx -> {
            ctx.result("О нас");
        });

        app.get("/hello", ctx -> {
            String name = ctx.queryParamAsClass("name", String.class)
                                .getOrDefault("World");
            ctx.result("Hello, " + name + "!");
        });

        app.get("/users/{id}/post/{postId}", ctx -> {
            String userId = ctx.pathParam("id");
            String postId = ctx.pathParam("postId");
            ctx.result("User ID: " + userId + ", Post ID: " + postId);
        });

        app.get("/xss-test", ctx -> {
            String userInput = ctx.queryParam("q");
            if (userInput == null) userInput = "empty";
            ctx.contentType("text/html");
            ctx.result("<h1>" + userInput + "</h1>");
        });

        app.get("/xss-safe", ctx -> {
            String userInput = ctx.queryParam("q");
            if (userInput == null) userInput = "empty";
            String escaped = userInput
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
            ctx.contentType("text/html");
            ctx.result("<h1>" + escaped + "</h1>");
        });

        app.start(7070);
    }
}
