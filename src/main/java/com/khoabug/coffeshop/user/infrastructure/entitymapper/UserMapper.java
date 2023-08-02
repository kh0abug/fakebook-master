package com.khoabug.coffeshop.user.infrastructure.entitymapper;

import com.khoabug.coffeshop.common.mapper.RowMapper;
import com.khoabug.coffeshop.user.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : DangKhoa
 * @since : 3/6/2023, Mon
 **/
public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong("UserID"));
//            user.setFirstName(resultSet.getString("Fname"));
//            user.setLastName(resultSet.getString("Lname"));
//            user.setUserName(resultSet.getString("Username"));
            user.setEmail(resultSet.getString("Email"));
            user.setPassword(resultSet.getString("Password"));
//            user.setPhone(resultSet.getString("Phone"));
//            user.setDob(resultSet.getDate("DOB"));
//            user.setGender(resultSet.getInt("GENDER"));
//            user.setCreatedDate(resultSet.getDate("createdate"));
        } catch (SQLException exception) {
            return null;
        }
        return user;
    }
}
