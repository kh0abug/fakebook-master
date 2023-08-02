package com.khoabug.coffeshop.user.controller; /**
 * @author : DangKhoa
 * @since : 3/11/2023, Sat
 **/

import com.khoabug.coffeshop.common.paging.Pageable;
import com.khoabug.coffeshop.common.paging.Sorter;
import com.khoabug.coffeshop.user.infrastructure.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    private final UserRepository repository;

    @Inject
    public HomeController(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Pageable pageable = Pageable.of(
                Pageable.getSorterOr(request, Sorter.by(Sorter.Direction.DESC, "name")),
                request, repository.count()
        );

        request.setAttribute("model", repository.findAll(pageable));
        request.setAttribute("pageI", pageable);
        request.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
    }
}
