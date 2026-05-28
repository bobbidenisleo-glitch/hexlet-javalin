package org.example.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import static io.javalin.rendering.template.TemplateUtil.model;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

import org.example.hexlet.controller.UsersController;
import org.example.hexlet.repository.BaseRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.stream.Collectors;

public final class HelloWorld {

    public static void main(String[] args) throws Exception {
        // Настройка базы данных
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");
        hikariConfig.setUsername("sa");
        hikariConfig.setPassword("");

        var dataSource = new HikariDataSource(hikariConfig);
        
        // Инициализация схемы БД
        var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
            .lines()
            .collect(Collectors.joining("\n"));
        
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        
        BaseRepository.dataSource = dataSource;

        // Настройка Javalin
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

        // Пользователи
        app.get("/users", UsersController::index);
        app.get("/users/build", UsersController::build);
        app.post("/users", UsersController::create);
        app.get("/users/{id}", UsersController::show);

        app.start(7070);
    }
}
