package org.example.hexlet.dto.users;

import org.example.hexlet.model.User;
import java.util.List;

public class UsersPage {
    private List<User> users;
    private String header;

    public UsersPage(List<User> users, String header) {
        this.users = users;
        this.header = header;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getHeader() {
        return header;
    }
}
