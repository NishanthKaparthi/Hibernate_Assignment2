package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();
	private static SessionFactory buildSessionFactory() {
		try {
			//creates the service object which holds and manage the services
			StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
			//initializes session factory object
			return new Configuration().configure().buildSessionFactory(serviceRegistry);
		}
		catch (Throwable e) {
			// TODO: handle exception
			System.err.print("Initial Session Factory creation failed." + e);
			  throw new ExceptionInInitializerError(e);
		}
		
	}
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void shutdown() {
		// Close caches and connection pools
		getSessionFactory().close();
	}
}
