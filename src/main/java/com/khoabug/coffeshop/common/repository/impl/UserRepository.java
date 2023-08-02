package com.khoabug.coffeshop.common.repository.impl;

import com.khoabug.coffeshop.user.infrastructure.entitymapper.UserLoginRequestMapper;
import com.khoabug.coffeshop.user.model.User;
import com.khoabug.coffeshop.common.paging.Pageable;
import com.khoabug.coffeshop.user.model.UserLoginRequest;
import com.khoabug.coffeshop.user.model.UserSignupRequest;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

/**
 * @author : DangKhoa
 * @since : 3/6/2023, Mon
 **/

@ApplicationScoped
public class UserRepository extends CrudRepository<User> implements com.khoabug.coffeshop.user.infrastructure.repository.UserRepository {

    @Override
    public List<User> findAll(Pageable pageable) {
        String sql = "SELECT * FROM app_user ";
        return pagingQuery(pageable, new UserLoginRequestMapper(), sql);
    }

    @Override
    public Long save(UserSignupRequest user) {
        String sql = """
                INSERT INTO app_user
                VALUES (?, ?, ?, ?, ?)
                """;
        return insert(sql, user.email(), user.password(), user.lastName());
    }

    @Override
    public User save(User user) {
        String sql = """
                UPDATE app_user
                SET ADDRESS = ?, ADDRESS = ?,ADDRESS = ?
                WHERE ID = ?
                """;
        update(sql, user.getFirstName(), user.getPassword(), user.getDob(), user.getId());
        return user;
    }

    @Override
    public Optional<User> findByUserNameAndPassword(UserLoginRequest user) {
        String sql = """
                SELECT * 
                FROM app_user
                WHERE email = ? AND password = ? 
                """;
        return query(sql, new UserLoginRequestMapper(), user.getEmail(),
                user.getPassword()).stream().findFirst();
    }

    @Override
    public int count(Object... parameter) {
        String sql = "SELECT COUNT(*) FROM app_user ";
        return count(sql);
    }
}
