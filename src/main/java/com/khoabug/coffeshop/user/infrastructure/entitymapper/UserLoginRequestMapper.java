package com.khoabug.coffeshop.user.infrastructure.entitymapper;

import com.khoabug.coffeshop.common.mapper.RowMapper;
import com.khoabug.coffeshop.user.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginRequestMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong("ID"));
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
        } catch (SQLException exception) {
            return null;
        }
        return user;
    }
}
