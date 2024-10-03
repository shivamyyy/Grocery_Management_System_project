package com.sms.dao;

import demo.com.grocery_management_system.entities.HibernateUtil;
import demo.com.grocery_management_system.entities.ordr;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private SessionFactory sessionFactory;

    public OrderDAOImpl() {
        // Initialize your session factory here (e.g., using HibernateUtil)
        this.sessionFactory = HibernateUtil.getSessionFactory(); // Update with actual method to get SessionFactory
    }

    @Override
    public void insert(ordr order) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void update(ordr order) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void delete(int orderId) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            ordr order = session.get(ordr.class, orderId);
            if (order != null) {
                session.delete(order);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public ordr findById(int orderId) {
        Session session = null;
        ordr order = null;

        try {
            session = sessionFactory.openSession();
            order = session.get(ordr.class, orderId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return order;
    }

    @Override
    public List<ordr> findAll() {
        Session session = null;
        Transaction transaction = null;
        List<ordr> orders = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Query<ordr> query = session.createQuery("from ordr", ordr.class);
            orders = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            if (session != null) session.close();
        }
        return orders;
    }
}
