package com.sms.dao;

import demo.com.grocery_management_system.entities.user;

import java.util.List;

public interface UserDAO {
    void insert(user user);
    void update(user user);
    void delete(String userId);
    user findById(String userId);
    List<user> findAll();
}
