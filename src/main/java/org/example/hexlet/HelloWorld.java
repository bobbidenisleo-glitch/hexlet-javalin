package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

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

        // Главная страница с проверкой куки
        app.get("/", ctx -> {
            // Читаем куку "visited" (по умолчанию false)
            String visitedCookie = ctx.cookie("visited");
            boolean visited = Boolean.parseBoolean(visitedCookie);
            
            // Создаём страницу с информацией о посещении
            MainPage page = new MainPage(visited);
            ctx.render("index.jte", model("page", page));
            
            // Устанавливаем куку "visited" для следующих посещений
            ctx.cookie("visited", String.valueOf(true));
        });

        app.start(7070);
    }
}
