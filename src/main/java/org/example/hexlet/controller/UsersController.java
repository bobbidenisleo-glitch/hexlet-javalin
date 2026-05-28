package org.example.hexlet.controller;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;
import static io.javalin.rendering.template.TemplateUtil.model;

import org.example.hexlet.NamedRoutes;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.dto.users.UserPage;
import org.example.hexlet.dto.users.UsersPage;
import org.example.hexlet.dto.users.BuildUserPage;
import org.example.hexlet.util.Security;

import java.sql.SQLException;
import java.util.List;

public class UsersController {

    // GET /users - список пользователей
    public static void index(Context ctx) {
        try {
            System.out.println("=== UsersController.index called ===");
            List<User> users = UserRepository.getEntities();
            System.out.println("Users count: " + users.size());
            UsersPage page = new UsersPage(users);
            System.out.println("Rendering users/index.jte");
            ctx.render("users/index.jte", model("page", page));
        } catch (Exception e) {
            System.out.println("ERROR in UsersController.index: " + e.getMessage());
            e.printStackTrace();
            ctx.result("Error: " + e.getMessage());
        }
    }

    // GET /users/{id} - просмотр пользователя
    public static void show(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("User not found"));
        UserPage page = new UserPage(user);
        ctx.render("users/show.jte", model("page", page));
    }

    // GET /users/build - форма создания пользователя
    public static void build(Context ctx) {
        BuildUserPage page = new BuildUserPage();
        ctx.render("users/build.jte", model("page", page));
    }

    // POST /users - создание пользователя
    public static void create(Context ctx) {
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");
        String passwordConfirmation = ctx.formParam("passwordConfirmation");
        
        try {
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
                    try {
                        String emailValue = value.trim().toLowerCase();
                        return UserRepository.findByEmail(emailValue).isEmpty();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
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
            
            ctx.sessionAttribute("flash", "Пользователь успешно зарегистрирован!");
            ctx.sessionAttribute("flashType", "success");
            
            ctx.redirect(NamedRoutes.usersPath());
            
        } catch (ValidationException e) {
            BuildUserPage page = new BuildUserPage(firstName, lastName, email, e.getErrors());
            ctx.render("users/build.jte", model("page", page));
            ctx.status(422);
        } catch (SQLException e) {
            ctx.result("Database error: " + e.getMessage());
        }
    }
}
