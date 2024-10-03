package com.sms;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import demo.com.grocery_management_system.entities.HibernateUtil;
import demo.com.grocery_management_system.entities.user;
import demo.com.grocery_management_system.entities.ordr;
import demo.com.grocery_management_system.entities.cart;
import demo.com.grocery_management_system.entities.review;
import demo.com.grocery_management_system.entities.orderitem;
import demo.com.grocery_management_system.entities.cartitem;
import demo.com.grocery_management_system.entities.category;
import demo.com.grocery_management_system.entities.product;

public class App {
    public static void main(String[] args) {
        // Obtain a Hibernate SessionFactory
        SessionFactory factory = HibernateUtil.getSessionFactory();

        // Open a new session
        Session session = factory.openSession();

        // Start a transaction
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            // Create User entity
            user newUser = new user("U001", "shivam", "password123", "shivam@example.com", "Shivam", "Yadav",
                    "123 Street, City", "9876543210", LocalDate.of(2003, 7, 29), LocalDate.now());
            session.save(newUser); // Save the User entity

            // Create Category entity
            category newCategory = new category("1", "Groceries", "All grocery items");
            session.save(newCategory); // Save the Category entity

            // Create Product entity
            product newProduct = new product(101, "Rice", "High-quality basmati rice", 250.50, 50, newCategory);
            session.save(newProduct); // Save the Product entity

            // Create Cart entity
            cart newCart = new cart(1, LocalDate.now(), newUser);
            session.save(newCart); // Save the Cart entity

            // Create CartItem entity
            cartitem newCartItem = new cartitem(1, 2, newCart, newProduct);
            session.save(newCartItem); // Save the CartItem entity

            // Create Order entity
            ordr newOrder = new ordr(1001, LocalDate.now(), 750.00, "Shipped", "Credit Card", newUser);
            session.save(newOrder); // Save the Order entity

            // Create OrderItem entity
            orderitem newOrderItem = new orderitem(1, 3, 250.50, newOrder, newProduct);
            session.save(newOrderItem); // Save the OrderItem entity

            // Create Review entity
            review newReview = new review(1, 4, "Good product, will buy again", newProduct, newUser);
            session.save(newReview); // Save the Review entity

            // Commit the transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Close the session
            session.close();
        }

        // Close the SessionFactory
        factory.close();
    }
}
