package crm_01;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import crm_01.model.Customer;
import crm_01.utils.HibernateUtils;

public class Test01 {
	
	@Test
	public void test01() {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCust_id(0L);
		customer.setCust_name("tereisha");
		session.save(customer);
		tx.commit();
		session.close();
	}
	
	@Test
	public void test02() {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		Customer customer = new Customer();
		customer.setCust_id(95L);
		customer.setCust_name("tom");
		session.delete(customer);
		session.save(customer);
		tx.commit();
		session.close();
		
	}
	@Test
	public void test03() {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.get(Customer.class, 96L);
		session.delete(customer);
		session.save(customer);
		tx.commit();
		session.close();
		
	}
	@Test
	public void test04() {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		Customer customer = session.load(Customer.class, 94L);
		session.delete(customer);
//		session.save(customer);
		tx.commit();
		session.close();
		
	}
	@Test
	public void test05() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Query hql = session.createQuery("from Customer");
		List<Customer> customerList = hql.list();
		for (Customer customer : customerList) {
			System.out.println(customer.getCust_name());
		}
		
		hql = session.createQuery("from Customer where cust_id = ?");
		hql.setParameter(0, 98L);
		customerList = hql.list();
		for (Customer customer : customerList) {
			System.out.println(customer.getCust_name());
		}
		
		hql = session.createQuery("from Customer");
		hql.setFirstResult(1);
		hql.setMaxResults(5);
		customerList = hql.list();
		for (Customer customer : customerList) {
			System.out.println(customer.getCust_name());
		}
		tx.commit();
	}
	@Test
	public void test06() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> customerList = criteria.list();
		for (Customer customer : customerList) {
			System.out.println(customer.getCust_name());
		}
		
		Criteria criteria01 = session.createCriteria(Customer.class);
		criteria01.add(Restrictions.eq("cust_name", "tom"));
		customerList = criteria01.list();
		for (Customer customer : customerList) {
			System.out.println(customer.getCust_name());
		}
		
		Criteria criteria02 = session.createCriteria(Customer.class);
		criteria02.setFirstResult(0);
		criteria02.setMaxResults(5);
		customerList = criteria02.list();
		for (Customer customer : customerList) {
			System.out.println(customer.getCust_name());
		}
		tx.commit();
	}
}
