package org.example.hexlet;

public class NamedRoutes {

    // ========== ГЛАВНАЯ СТРАНИЦА ==========
    public static String rootPath() {
        return "/";
    }

    // ========== МАРШРУТЫ ПОЛЬЗОВАТЕЛЕЙ ==========
    public static String usersPath() {
        return "/u";
    }

    public static String buildUserPath() {
        return "/users/build";
    }

    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }

    public static String userPath(String id) {
        return "/users/" + id;
    }

    // ========== МАРШРУТЫ СЕССИЙ (ЛОГИН/ВЫХОД) ==========
    public static String sessionsPath() {
        return "/sessions";
    }

    public static String buildSessionPath() {
        return "/sessions/build";
    }

    // ========== МАРШРУТЫ СТАТЕЙ ==========
    public static String articlesPath() {
        return "/articles";
    }

    public static String buildArticlePath() {
        return "/articles/build";
    }

    public static String articlePath(Long id) {
        return articlePath(String.valueOf(id));
    }

    public static String articlePath(String id) {
        return "/articles/" + id;
    }

    // ========== МАРШРУТЫ КУРСОВ ==========
    public static String coursesPath() {
        return "/courses";
    }

    public static String coursePath(Long id) {
        return coursePath(String.valueOf(id));
    }

    public static String coursePath(String id) {
        return "/courses/" + id;
    }
}
