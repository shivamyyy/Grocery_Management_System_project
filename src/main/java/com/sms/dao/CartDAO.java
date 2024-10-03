package com.sms.dao;

import demo.com.grocery_management_system.entities.cart;
import java.util.List;

public interface CartDAO {
    void insert(cart cart);
    void update(cart cart);
    void delete(int cartId);
    cart findById(int cartId);
    List<cart> findAll();
}
