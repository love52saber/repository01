package crm_01;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import crm_01.utils.HibernateUtils;

public class Test03_hql {
	
	@Test
	public void test01() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<String> list = session.createQuery("select username from User").list();
		for (String username : list) {
			System.out.println(username);
		}
		tx.commit();
	}
	@Test
	public void test02() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<String> list = session.createQuery("select username from User").list();
		for (String username : list) {
			System.out.println(username);
		}
		tx.commit();
	}
}
