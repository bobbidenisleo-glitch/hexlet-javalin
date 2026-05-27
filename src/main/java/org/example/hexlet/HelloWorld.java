package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.dto.MainPage;

import java.nio.file.Path;

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

        // Сессии (логин/выход)
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.delete(NamedRoutes.sessionsPath(), SessionsController::destroy);

        // Главная страница (с информацией о текущем пользователе)
        app.get(NamedRoutes.rootPath(), ctx -> {
            String currentUser = ctx.sessionAttribute("currentUser");
            MainPage page = new MainPage(currentUser);
            ctx.render("index.jte", model("page", page));
        });

        app.start(7070);
    }
}
