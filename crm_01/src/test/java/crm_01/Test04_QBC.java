package crm_01;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import crm_01.model.Customer;
import crm_01.model.User;
import crm_01.utils.HibernateUtils;

public class Test04_QBC {
	
	@Test
	public void test01() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> customerList = criteria.list();
		for (Customer customer : customerList) {
			System.out.println(customer.getCust_name());
		}
		
		tx.commit();
	}
	@Test
	public void test02() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", "小军"));
		User user = (User) criteria.uniqueResult();
//		List<User> UserList = criteria.list();
//		for (User user : UserList) {
//			System.out.println(user.getUsername());
//		}
		System.out.println(user.getUsername());
		
		tx.commit();
	}
}
