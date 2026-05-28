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
import org.example.hexlet.controller.SessionsController;
import org.example.hexlet.controller.CoursesController;
import org.example.hexlet.dto.MainPage;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.BaseRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.stream.Collectors;

public final class HelloWorld {

    private static String getDatabaseUrl() {
        return System.getenv().getOrDefault("DATABASE_URL", "jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");
    }

    public static void main(String[] args) throws Exception {
        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(getDatabaseUrl());
        
        String dbUrl = System.getenv("DATABASE_URL");
        if (dbUrl != null && dbUrl.contains("postgresql")) {
            hikariConfig.setDriverClassName("org.postgresql.Driver");
        } else {
            hikariConfig.setUsername("sa");
            hikariConfig.setPassword("");
        }

        var dataSource = new HikariDataSource(hikariConfig);
        BaseRepository.dataSource = dataSource;

        // Инициализация схемы БД
        if (dbUrl == null || !dbUrl.contains("postgresql")) {
            // H2: создаём таблицы из schema.sql
            var url = HelloWorld.class.getClassLoader().getResourceAsStream("schema.sql");
            var sql = new BufferedReader(new InputStreamReader(url))
                .lines()
                .collect(Collectors.joining("\n"));
            
            try (var connection = dataSource.getConnection();
                 var statement = connection.createStatement()) {
                statement.execute(sql);
            }
        } else {
            // PostgreSQL: создаём таблицы, если их нет
            try (var connection = dataSource.getConnection();
                 var statement = connection.createStatement()) {
                
                String createUsersTable = """
                    CREATE TABLE IF NOT EXISTS users (
                        id BIGSERIAL PRIMARY KEY,
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL UNIQUE,
                        password VARCHAR(255) NOT NULL
                    )
                """;
                statement.execute(createUsersTable);
                
                String createCoursesTable = """
                    CREATE TABLE IF NOT EXISTS courses (
                        id BIGSERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        description TEXT
                    )
                """;
                statement.execute(createCoursesTable);
                
                System.out.println("Tables created/verified successfully");
            }
        }

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
            User currentUser = ctx.sessionAttribute("currentUser");
            String userName = currentUser != null ? (currentUser.getFirstName() + " " + currentUser.getLastName()) : null;
            MainPage page = new MainPage(userName);
            ctx.render("index.jte", model("page", page));
        });

        // Пользователи
        app.get("/users", UsersController::index);
        app.get("/users/build", UsersController::build);
        app.post("/users", UsersController::create);
        app.get("/users/{id}", UsersController::show);

        // Курсы
        app.get("/courses", CoursesController::index);

        // Сессии (логин/выход)
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        app.post(NamedRoutes.sessionsPath(), SessionsController::create);
        app.post("/sessions/delete", SessionsController::destroy);

        app.start(7070);
    }
}
