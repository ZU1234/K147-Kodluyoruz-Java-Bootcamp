package com.emlakcepte.question1B.model;

public class UserSearch {
    private String email;
    private String search;

    public UserSearch(String email, String search) {
        this.email = email;
        this.search = search;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
