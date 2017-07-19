package ua.lviv.ltl.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	private HibernateUtil() {
	}

	static {
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}

}
