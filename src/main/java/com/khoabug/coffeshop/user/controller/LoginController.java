package com.khoabug.coffeshop.user.controller;


import com.khoabug.coffeshop.user.exception.UserNotFoundException;
import com.khoabug.coffeshop.user.infrastructure.repository.UserRepository;
import com.khoabug.coffeshop.user.model.User;
import com.khoabug.coffeshop.common.utils.FormUtil;
import com.khoabug.coffeshop.user.model.UserLoginRequest;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {

    @Inject
    private UserRepository repository;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       UserLoginRequest inputUser = FormUtil.toModel(UserLoginRequest.class, request);

        Map<String, String> messages = new HashMap<>();

        if (inputUser.getEmail() == null || inputUser.getEmail().isEmpty()) {
            messages.put("email", "Please enter email");
        }
        if (inputUser.getPassword() == null || inputUser.getPassword().isEmpty()) {
            messages.put("password", "Please enter password");
        }
        if (messages.isEmpty()) {
            User user = repository.findByUserNameAndPassword(inputUser).orElseThrow(UserNotFoundException::new);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/home?page=1&size=10");
                return;
            } else {
                messages.put("login", "Unknown login, please try again");
            }
        }
        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
