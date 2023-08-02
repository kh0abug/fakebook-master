package com.khoabug.coffeshop.user.infrastructure.repository;

import com.khoabug.coffeshop.common.paging.Pageable;
import com.khoabug.coffeshop.common.repository.Repository;
import com.khoabug.coffeshop.user.model.User;
import com.khoabug.coffeshop.user.model.UserLoginRequest;
import com.khoabug.coffeshop.user.model.UserSignupRequest;

import java.util.List;
import java.util.Optional;

/**
 * @author : DangKhoa
 * @since : 3/6/2023, Mon
 **/
public interface UserRepository extends Repository<User> {
    List<User> findAll(Pageable pageable);

    Long save(UserSignupRequest user);

    User save(User user);

    Optional<User> findByUserNameAndPassword(UserLoginRequest user);

    int count(Object... parameter);
}