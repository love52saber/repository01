package crm_01.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static Configuration configure;
	private static SessionFactory sessionFactory;
	
	static{
		configure = new Configuration().configure();
		sessionFactory = configure.buildSessionFactory();
	}
	
	/**
	 * 获取session
	 * @return
	 */
	public static Session getSession() {
		return sessionFactory.openSession();
	}
	
	public static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
