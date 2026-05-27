package org.example.hexlet.controller;

import io.javalin.http.Context;
import org.example.hexlet.NamedRoutes;  // исправлен импорт

public class SessionsController {

    // GET /sessions/build - отображение формы логина
    public static void build(Context ctx) {
        ctx.render("sessions/build.jte");
    }

    // POST /sessions - процесс логина
    public static void create(Context ctx) {
        String nickname = ctx.formParam("nickname");
        
        // Сохраняем nickname в сессию
        ctx.sessionAttribute("currentUser", nickname);
        
        // Редирект на главную страницу
        ctx.redirect(NamedRoutes.rootPath());
    }

    // DELETE /sessions - выход (разлогин)
    public static void destroy(Context ctx) {
        // Удаляем пользователя из сессии
        ctx.sessionAttribute("currentUser", null);
        // Редирект на главную
        ctx.redirect(NamedRoutes.rootPath());
    }
}
