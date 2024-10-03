package com.sms.dao;

import demo.com.grocery_management_system.entities.HibernateUtil;
import demo.com.grocery_management_system.entities.cartitem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CartItemDAOImpl implements CartItemDAO {

    @Override
    public void insert(cartitem cartItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cartItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(cartitem cartItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(cartItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int cartItemId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            cartitem cartItem = session.get(cartitem.class, cartItemId);
            if (cartItem != null) {
                session.delete(cartItem);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public cartitem findById(int cartItemId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(cartitem.class, cartItemId);
        }
    }

    @Override
    public List<cartitem> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from cartitem", cartitem.class).list();
        }
    }
}
