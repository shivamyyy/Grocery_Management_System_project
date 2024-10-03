package com.sms.dao;

import demo.com.grocery_management_system.entities.ordr;
import java.util.List;

public interface OrderDAO {
    void insert(ordr order);
    void update(ordr order);
    void delete(int orderId);
    ordr findById(int orderId);
    List<ordr> findAll(); // Add this method
}
