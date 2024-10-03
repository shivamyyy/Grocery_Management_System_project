package com.sms.dao;

import demo.com.grocery_management_system.entities.product;
import java.util.List;

public interface ProductDAO {
    void insert(product p);
    void update(product p);
    void delete(int productId);
    product findById(int productId);
    List<product> findAll();
}
