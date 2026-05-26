package org.example.hexlet;

public class NamedRoutes {

    // ========== ГЛАВНАЯ СТРАНИЦА ==========
    public static String rootPath() {
        return "/";
    }

    // ========== МАРШРУТЫ ПОЛЬЗОВАТЕЛЕЙ ==========
    
    // Список пользователей (НОВЫЙ URL - /u)
    public static String usersPath() {
        return "/u";  // было "/users"
    }
    
    // Форма создания пользователя
    public static String buildUserPath() {
        return "/users/build";
    }
    
    // Просмотр конкретного пользователя (для Long)
    public static String userPath(Long id) {
        return userPath(String.valueOf(id));
    }
    
    // Просмотр конкретного пользователя (для String)
    public static String userPath(String id) {
        return "/users/" + id;
    }

    // ========== МАРШРУТЫ СТАТЕЙ ==========
    
    // Список статей
    public static String articlesPath() {
        return "/articles";
    }
    
    // Форма создания статьи
    public static String buildArticlePath() {
        return "/articles/build";
    }
    
    // Просмотр статьи (для Long)
    public static String articlePath(Long id) {
        return articlePath(String.valueOf(id));
    }
    
    // Просмотр статьи (для String)
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
