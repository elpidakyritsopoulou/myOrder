package com.example.myorder.Model;

public class User {
    private String username;
    private String Password;



    public User() {
    }

    public User(String name, String password) {
        this.username = name;
        this.Password = password;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}
