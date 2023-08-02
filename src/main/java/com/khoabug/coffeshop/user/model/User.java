package com.khoabug.coffeshop.user.model;

import com.khoabug.coffeshop.common.model.AbstractModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import static com.khoabug.coffeshop.user.model.User.Scope.*;

/**
 * @author : DangKhoa
 * @since : 3/6/2023, Mon
 **/
public class User extends AbstractModel<User> implements Serializable {
    private String email;
    private String password;
    private boolean gender;
    private boolean isActive;
    private String firstName;
    private String lastName;
    private Date dob;
    private String phone;
    private Enum role;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Enum getRole() {
        return role;
    }

    public void setRole(Enum role) {
        this.role = role;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public enum Role{
        USER(
                Set.of(
                        USER_WRITE_AUTHORITY,
                        USER_READ_AUTHORITY
                )
        ),
        ADMIN(
                Set.of(
                        ADMIN_WRITE_AUTHORITY,
                        ADMIN_READ_AUTHORITY,
                        MANAGER_READ_AUTHORITY,
                        MANAGER_WRITE_AUTHORITY
                )
        ),
        MANAGER(
                Set.of(
                        MANAGER_READ_AUTHORITY,
                        MANAGER_WRITE_AUTHORITY
                )
        );

        private final Set<Scope> scope;

        Role(Set<Scope> scope) {
            this.scope = scope;
        }
    }

    public enum Scope{
        ADMIN_READ_AUTHORITY("admin:read"),
        ADMIN_WRITE_AUTHORITY("admin:write"),
        MANAGER_READ_AUTHORITY("manager:read"),
        MANAGER_WRITE_AUTHORITY("manager:write"),
        USER_WRITE_AUTHORITY("user:write"),
        USER_READ_AUTHORITY("user:write");

        private final String scope;

        Scope(String scope) {
            this.scope = scope;
        }
    }

}


