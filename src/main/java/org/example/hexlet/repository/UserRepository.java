package org.example.hexlet.repository;

import org.example.hexlet.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    private static List<User> entities = new ArrayList<>();
    private static Long nextId = 1L;

    public static void save(User user) {
        if (user.getId() == null) {
            user.setId(nextId++);
            entities.add(user);
        }
    }

    public static Optional<User> find(Long id) {
        return entities.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst();
    }

    public static List<User> getEntities() {
        return new ArrayList<>(entities);
    }

    public static void delete(Long id) {
        entities.removeIf(user -> user.getId().equals(id));
    }
}
