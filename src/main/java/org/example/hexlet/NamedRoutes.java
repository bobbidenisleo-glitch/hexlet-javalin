package org.example.hexlet;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String usersPath() {
        return "/users";  // было "/u"
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
}
