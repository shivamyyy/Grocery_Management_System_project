package com.sms.dao;

import demo.com.grocery_management_system.entities.cart;
import org.hibernate.Session;
import org.hibernate.Transaction;
import demo.com.grocery_management_system.entities.HibernateUtil;
import java.util.List;

public class CartDAOImpl implements CartDAO {

    @Override
    public void insert(cart cart) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(cart cart) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(cart);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int cartId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            cart cart = session.get(cart.class, cartId);
            if (cart != null) {
                session.delete(cart);
                System.out.println("Cart is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public cart findById(int cartId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(cart.class, cartId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<cart> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from cart").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
