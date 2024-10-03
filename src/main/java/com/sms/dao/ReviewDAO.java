package com.sms.dao;

import demo.com.grocery_management_system.entities.review;
import java.util.List;

public interface ReviewDAO {
    void insert(review review);
    void update(review review);
    void delete(int reviewId);
    review findById(int reviewId);
    List<review> findAll();
}
