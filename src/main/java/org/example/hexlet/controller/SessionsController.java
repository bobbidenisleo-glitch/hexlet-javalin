package org.example.hexlet.controller;

import io.javalin.http.Context;
import org.example.hexlet.NamedRoutes;
import org.example.hexlet.model.User;
import org.example.hexlet.repository.UserRepository;
import org.example.hexlet.util.Security;

public class SessionsController {

    // GET /sessions/build — показать форму логина
    public static void build(Context ctx) {
        ctx.render("sessions/build.jte");
    }

    // POST /sessions — логин
    public static void create(Context ctx) {
        String email = ctx.formParam("email");
        String password = ctx.formParam("password");

        var userOptional = UserRepository.findByEmail(email);
        
        if (userOptional.isEmpty() || !Security.encrypt(password).equals(userOptional.get().getPassword())) {
            ctx.sessionAttribute("flash", "Неверный email или пароль");
            ctx.redirect(NamedRoutes.buildSessionPath());
            return;
        }

        ctx.sessionAttribute("currentUser", userOptional.get());
        ctx.redirect(NamedRoutes.rootPath());
    }

    // POST /sessions/delete — логаут
    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
}
