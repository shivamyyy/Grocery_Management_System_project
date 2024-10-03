package com.sms.dao;

import com.sms.dao.ProductDAO;
import demo.com.grocery_management_system.entities.product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import demo.com.grocery_management_system.entities.HibernateUtil; // Assuming you have a HibernateUtil class for session management
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public void insert(product p) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(product p) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(p);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int productId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            product p = session.get(product.class, productId);
            if (p != null) {
                session.delete(p);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public product findById(int productId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(product.class, productId);
        }
    }

    @Override
    public List<product> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<product> query = session.createQuery("from product", product.class);
            return query.list();
        }
    }
}
