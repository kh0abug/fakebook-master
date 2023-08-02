package com.khoabug.coffeshop.user.model;

/**
 * @author : khoabug
 * @created : 7/29/23, Saturday
 **/
public class UserLoginRequest{
    private String email;
    private String password;

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
