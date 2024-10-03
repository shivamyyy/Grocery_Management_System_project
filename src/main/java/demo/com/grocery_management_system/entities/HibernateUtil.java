package demo.com.grocery_management_system.entities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			return new
					Configuration().configure("Hibernate.cfg.xml").addAnnotatedClass(user.class)
					.addAnnotatedClass(review.class)
					.addAnnotatedClass(product.class)
					.addAnnotatedClass(orderitem.class)
					.addAnnotatedClass(ordr.class)
					.addAnnotatedClass(category.class)
					.addAnnotatedClass(cartitem.class)
					.addAnnotatedClass(cart.class)
						.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}	
