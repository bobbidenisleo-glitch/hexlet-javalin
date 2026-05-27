package org.example.hexlet.dto;

public class MainPage {
    private String currentUser;

    public MainPage(String currentUser) {
        this.currentUser = currentUser;
    }

    public String getCurrentUser() {
        return currentUser;
    }
}
