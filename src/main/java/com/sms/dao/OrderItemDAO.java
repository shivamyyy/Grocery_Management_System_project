package com.sms.dao;

import demo.com.grocery_management_system.entities.orderitem;
import java.util.List;

public interface OrderItemDAO {
    void insert(orderitem orderItem); // Insert new orderitem
    void update(orderitem orderItem); // Update existing orderitem
    void delete(int orderItemId); // Delete an orderitem by ID
    orderitem findById(int orderItemId); // Find an orderitem by ID
    List<orderitem> findAll(); // Retrieve all order items
}
