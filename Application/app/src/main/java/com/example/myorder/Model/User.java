package com.example.myorder.Model;

public class User {

    public String restaurant_name, phone, email, password, username;

    public User() {
    }

    public User(String restaurant_name, String username, String phone, String email, String password) {
        this.restaurant_name = restaurant_name;
        this.username = username;
        this.phone = phone;
        this.email = email;
        this.password = password;

    }

    public String getRestaurant_name() {
        return restaurant_name;
    }

    public void setRestaurant_name(String restaurant_name) {
        this.restaurant_name = restaurant_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
