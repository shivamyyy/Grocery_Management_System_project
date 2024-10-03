package com.sms.dao;

import demo.com.grocery_management_system.entities.category;
import java.util.List;

public interface CategoryDAO {
    void insert(category category); // Insert new category
    void update(category category); // Update existing category
    void delete(String categoryId); // Delete a category by ID
    category findById(String categoryId); // Find a category by ID
    List<category> findAll(); // Retrieve all categories
}
