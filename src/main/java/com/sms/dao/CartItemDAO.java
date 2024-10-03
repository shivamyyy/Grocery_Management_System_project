package com.sms.dao;

import demo.com.grocery_management_system.entities.cartitem;
import java.util.List;

public interface CartItemDAO {
    void insert(cartitem cartItem);
    void update(cartitem cartItem);
    void delete(int cartItemId);
    cartitem findById(int cartItemId);
    List<cartitem> findAll();
}
