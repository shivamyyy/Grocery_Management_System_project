package com.sms.dao;

import demo.com.grocery_management_system.entities.HibernateUtil;
import demo.com.grocery_management_system.entities.review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ReviewDAOImpl implements ReviewDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public void insert(review review) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(review);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(review review) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(review);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int reviewId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            review review = session.get(review.class, reviewId);
            if (review != null) {
                session.delete(review);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public review findById(int reviewId) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(review.class, reviewId);
        }
    }

    @Override
    public List<review> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from review", review.class).list();
        }
    }
}
