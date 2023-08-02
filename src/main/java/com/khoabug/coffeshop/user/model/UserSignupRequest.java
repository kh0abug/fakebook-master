package com.khoabug.coffeshop.user.model;

/**
 * @author : khoabug
 * @created : 7/24/23, Monday
 **/
public record UserSignupRequest(
        String email,
        String password,
        String lastName) {

}
