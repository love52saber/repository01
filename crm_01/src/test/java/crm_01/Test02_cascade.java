package crm_01;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import crm_01.model.Customer;
import crm_01.model.Linkman;
import crm_01.utils.HibernateUtils;

public class Test02_cascade {
	
	@Test
	public void test01() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("阮经理");
		
		Linkman linkman01 = new Linkman();
		linkman01.setLkm_name("gjy");
		Linkman linkman02 = new Linkman();
		linkman02.setLkm_name("lcg");
		
		customer.getLinkmans().add(linkman01);
		customer.getLinkmans().add(linkman02);
		
		linkman01.setCustomer(customer);
		linkman02.setCustomer(customer);
		
		session.save(customer);
		session.save(linkman01);
		session.save(linkman02);
		
		tx.commit();
		
	}
	@Test
	public void test02() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("阮经理");
		
		Linkman linkman01 = new Linkman();
		linkman01.setLkm_name("gjy");
		Linkman linkman02 = new Linkman();
		linkman02.setLkm_name("lcg");
		
		customer.getLinkmans().add(linkman01);
		customer.getLinkmans().add(linkman02);
		
		linkman01.setCustomer(customer);
		linkman02.setCustomer(customer);
		
		session.save(customer);
		
		tx.commit();
	}
	@Test
	public void test03() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setCust_name("阮经理2");
		
		Linkman linkman01 = new Linkman();
		linkman01.setLkm_name("gjy2");
		Linkman linkman02 = new Linkman();
		linkman02.setLkm_name("lcg2");
		
		customer.getLinkmans().add(linkman01);
		customer.getLinkmans().add(linkman02);
		
		linkman01.setCustomer(customer);
		linkman02.setCustomer(customer);
		
		session.save(customer);
		
		tx.commit();
		
	}
	@Test
	public void test04() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, 4L);
		session.delete(customer);
		
		tx.commit();
		
	}
	@Test
	public void test05() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Linkman linkman = session.get(Linkman.class, 3L);
		session.delete(linkman);
		
		tx.commit();
		
	}
	//多表操作
	@Test
	public void test06() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Linkman linkman = session.get(Linkman.class, 3L);
		session.delete(linkman);
		
		tx.commit();
		
	}
}
