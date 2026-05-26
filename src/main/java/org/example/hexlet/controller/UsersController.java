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

import java.util.List;

public class UsersController {

    // GET /users - список пользователей
    public static void index(Context ctx) {
        List<User> users = UserRepository.getEntities();
        UsersPage page = new UsersPage(users);
        ctx.render("users/index.jte", model("page", page));
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
        
        // ОТЛАДОЧНЫЙ ВЫВОД
        System.out.println("=== CREATE USER ===");
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        
        try {
            // Валидация имени
            String validFirstName = ctx.formParamAsClass("firstName", String.class)
                .check(value -> value != null && !value.trim().isEmpty(), "Имя обязательно")
                .get();
            validFirstName = validFirstName.trim();
            validFirstName = validFirstName.substring(0, 1).toUpperCase() + 
                            validFirstName.substring(1).toLowerCase();
            
            // Валидация фамилии
            String validLastName = ctx.formParamAsClass("lastName", String.class)
                .check(value -> value != null && !value.trim().isEmpty(), "Фамилия обязательна")
                .get();
            validLastName = validLastName.trim();
            validLastName = validLastName.substring(0, 1).toUpperCase() + 
                           validLastName.substring(1).toLowerCase();
            
            // Валидация email
            String validEmail = ctx.formParamAsClass("email", String.class)
                .check(value -> value != null && !value.trim().isEmpty(), "Email обязателен")
                .check(value -> {
                    String emailValue = value.trim().toLowerCase();
                    return UserRepository.findByEmail(emailValue).isEmpty();
                }, "Пользователь с таким email уже существует")
                .get();
            validEmail = validEmail.trim().toLowerCase();
            
            // Валидация пароля
            String validPassword = ctx.formParamAsClass("password", String.class)
                .check(value -> value != null && value.length() >= 6, "Пароль должен содержать минимум 6 символов")
                .check(value -> value != null && value.equals(passwordConfirmation), "Пароли не совпадают")
                .get();
            
            String encryptedPassword = Security.encrypt(validPassword);
            
            User user = new User(validFirstName, validLastName, validEmail, encryptedPassword);
            UserRepository.save(user);
            
            // ОТЛАДОЧНЫЙ ВЫВОД
            System.out.println("User saved! ID: " + user.getId());
            System.out.println("Total users in repo: " + UserRepository.getEntities().size());
            
            ctx.redirect(NamedRoutes.usersPath());
            
        } catch (ValidationException e) {
            System.out.println("Validation error occurred!");
            BuildUserPage page = new BuildUserPage(firstName, lastName, email, e.getErrors());
            ctx.render("users/build.jte", model("page", page));
            ctx.status(422);
        }
    }

    // GET /users/{id}/edit - форма редактирования пользователя
    public static void edit(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        User user = UserRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("User not found"));
        ctx.render("users/edit.jte", model("user", user));
    }

    // PATCH /users/{id} - обновление пользователя
    public static void update(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        String firstName = ctx.formParam("firstName");
        String lastName = ctx.formParam("lastName");
        String email = ctx.formParam("email");
        
        User user = UserRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("User not found"));
        
        if (firstName != null && !firstName.trim().isEmpty()) {
            String capitalized = firstName.trim();
            capitalized = capitalized.substring(0, 1).toUpperCase() + 
                         capitalized.substring(1).toLowerCase();
            user.setFirstName(capitalized);
        }
        
        if (lastName != null && !lastName.trim().isEmpty()) {
            String capitalized = lastName.trim();
            capitalized = capitalized.substring(0, 1).toUpperCase() + 
                         capitalized.substring(1).toLowerCase();
            user.setLastName(capitalized);
        }
        
        if (email != null && !email.trim().isEmpty()) {
            user.setEmail(email.trim().toLowerCase());
        }
        
        UserRepository.save(user);
        ctx.redirect(NamedRoutes.usersPath());
    }

    // DELETE /users/{id} - удаление пользователя
    public static void destroy(Context ctx) {
        Long id = ctx.pathParamAsClass("id", Long.class).get();
        UserRepository.delete(id);
        ctx.redirect(NamedRoutes.usersPath());
    }
}
