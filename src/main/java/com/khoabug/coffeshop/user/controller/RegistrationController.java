package com.khoabug.coffeshop.user.controller;

import com.khoabug.coffeshop.common.utils.FormUtil;
import com.khoabug.coffeshop.user.model.UserSignupRequest;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegistrationController", value = "/signup")
public class RegistrationController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserSignupRequest registerUses = FormUtil.toModel(UserSignupRequest.class, request);



    }
}
