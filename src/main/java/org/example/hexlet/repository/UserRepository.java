package org.example.hexlet.repository;

import org.example.hexlet.model.User;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends BaseRepository {

    public static void save(User user) throws SQLException {
        String sql = "INSERT INTO users (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, user.getFirstName());
            preparedStatement.setString(2, user.getLastName());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
            
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                user.setId(generatedKeys.getLong(1));
            }
        }
    }

    public static Optional<User> find(Long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var firstName = resultSet.getString("first_name");
                var lastName = resultSet.getString("last_name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(firstName, lastName, email, password);
                user.setId(id);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static List<User> getEntities() throws SQLException {
        String sql = "SELECT * FROM users";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<User>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var firstName = resultSet.getString("first_name");
                var lastName = resultSet.getString("last_name");
                var email = resultSet.getString("email");
                var password = resultSet.getString("password");
                var user = new User(firstName, lastName, email, password);
                user.setId(id);
                result.add(user);
            }
            return result;
        }
    }

    public static Optional<User> findByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM users WHERE email = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var id = resultSet.getLong("id");
                var firstName = resultSet.getString("first_name");
                var lastName = resultSet.getString("last_name");
                var password = resultSet.getString("password");
                var user = new User(firstName, lastName, email, password);
                user.setId(id);
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static void delete(Long id) throws SQLException {
        String sql = "DELETE FROM users WHERE id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        }
    }
}
