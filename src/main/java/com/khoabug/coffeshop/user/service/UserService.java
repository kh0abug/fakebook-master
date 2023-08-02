package com.khoabug.coffeshop.user.service;


import com.khoabug.coffeshop.common.repository.impl.UserRepository;
import com.khoabug.coffeshop.user.model.User;
import com.khoabug.coffeshop.common.paging.Pageable;
import jakarta.inject.Inject;

import java.util.List;

/**
 * @author : DangKhoa
 * @since : 3/6/2023, Mon
 **/

public class UserService {

    @Inject
    private UserRepository userDAO;

    public List<User> findAll(Pageable pageable) {
        return userDAO.findAll(pageable);
    }

    public int getTotalUser(Object... parameters) {
        return userDAO.count(parameters);
    }

}
