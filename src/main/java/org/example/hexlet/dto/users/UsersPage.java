package org.example.hexlet.dto.users;

import org.example.hexlet.model.User;
import java.util.List;

public class UsersPage {
    private List<User> users;
    private String term;

    public UsersPage(List<User> users, String term) {
        this.users = users;
        this.term = term;
    }

    public List<User> getUsers() {
        return users;
    }

    public String getTerm() {
        return term;
    }
}
