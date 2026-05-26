package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import static io.javalin.rendering.template.TemplateUtil.model;

import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.util.Security;

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

        // GET /users/build - форма создания пользователя
        app.get("/users/build", ctx -> {
            BuildUserPage page = new BuildUserPage();
            ctx.render("users/build.jte", model("page", page));
        });

        // POST /users - обработка формы
        app.post("/users", ctx -> {
            String firstName = ctx.formParam("firstName");
            String lastName = ctx.formParam("lastName");
            String email = ctx.formParam("email");
            String password = ctx.formParam("password");
            String passwordConfirmation = ctx.formParam("passwordConfirmation");
            
            try {
                // Валидация
                String validFirstName = ctx.formParamAsClass("firstName", String.class)
                    .check(value -> value != null && !value.trim().isEmpty(), "Имя обязательно")
                    .get();
                validFirstName = validFirstName.trim();
                validFirstName = validFirstName.substring(0, 1).toUpperCase() + 
                                validFirstName.substring(1).toLowerCase();
                
                String validLastName = ctx.formParamAsClass("lastName", String.class)
                    .check(value -> value != null && !value.trim().isEmpty(), "Фамилия обязательна")
                    .get();
                validLastName = validLastName.trim();
                validLastName = validLastName.substring(0, 1).toUpperCase() + 
                               validLastName.substring(1).toLowerCase();
                
                String validEmail = ctx.formParamAsClass("email", String.class)
                    .check(value -> value != null && !value.trim().isEmpty(), "Email обязателен")
                    .check(value -> {
                        String emailValue = value.trim().toLowerCase();
                        return UserRepository.findByEmail(emailValue).isEmpty();
                    }, "Пользователь с таким email уже существует")
                    .get();
                validEmail = validEmail.trim().toLowerCase();
                
                String validPassword = ctx.formParamAsClass("password", String.class)
                    .check(value -> value != null && value.length() >= 6, "Пароль должен содержать минимум 6 символов")
                    .check(value -> value != null && value.equals(passwordConfirmation), "Пароли не совпадают")
                    .get();
                
                String encryptedPassword = Security.encrypt(validPassword);
                
                User user = new User(validFirstName, validLastName, validEmail, encryptedPassword);
                UserRepository.save(user);
                
                ctx.redirect("/users");
                
            } catch (ValidationException e) {
                BuildUserPage page = new BuildUserPage(firstName, lastName, email, e.getErrors());
                ctx.render("users/build.jte", model("page", page));
                ctx.status(422);
            }
        });

        // Список пользователей
        app.get("/users", ctx -> {
            List<User> users = UserRepository.getEntities();
            UsersPage page = new UsersPage(users);
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

        app.start(7070);
    }
}
