package com.sms.dao;

import com.sms.dao.OrderItemDAO;
import demo.com.grocery_management_system.entities.orderitem;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrderItemDAOImpl implements OrderItemDAO {

    // Initialize SessionFactory
    private SessionFactory sessionFactory;

    public OrderItemDAOImpl() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public void insert(orderitem orderItem) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(orderItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void update(orderitem orderItem) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(orderItem);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int orderItemId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            orderitem orderItem = session.get(orderitem.class, orderItemId);
            if (orderItem != null) {
                session.delete(orderItem);
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
    public orderitem findById(int orderItemId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(orderitem.class, orderItemId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<orderitem> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<orderitem> query = session.createQuery("FROM orderitem", orderitem.class);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
