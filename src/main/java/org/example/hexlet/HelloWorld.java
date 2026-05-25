package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

import org.example.hexlet.model.User;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;

import java.nio.file.Path;
import java.util.List;

public final class HelloWorld {

    private static final List<User> USERS = List.of(
        new User(1L, "Иван", "Иванов", "ivan@example.com"),
        new User(2L, "Мария", "Петрова", "maria@example.com"),
        new User(3L, "Алексей", "Сидоров", "alex@example.com")
    );

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

        // Список пользователей
        app.get("/users", ctx -> {
            UsersPage page = new UsersPage(USERS, "Список пользователей");
            ctx.render("users/index.jte", model("page", page));
        });

        // Просмотр пользователя
        app.get("/users/{id}", ctx -> {
            try {
                Long id = Long.parseLong(ctx.pathParam("id"));
                User user = USERS.stream()
                    .filter(u -> u.getId().equals(id))
                    .findFirst()
                    .orElse(null);
                
                if (user == null) {
                    ctx.status(404).result("User not found");
                    return;
                }
                
                UserPage page = new UserPage(user);
                ctx.render("users/show.jte", model("page", page));
            } catch (NumberFormatException e) {
                ctx.status(404).result("User not found");
            }
        });

        app.start(7070);
    }
}
