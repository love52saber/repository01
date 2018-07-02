package crm_01;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import crm_01.model.Customer;
import crm_01.model.Linkman;
import crm_01.model.Role;
import crm_01.model.User;
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

	// 多表操作
	@Test
	public void test06() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		// 保存两个用户:
		User user1 = new User();
		user1.setUsername("张三");
		User user2 = new User();
		user2.setUsername("李四");

		// 保存三个角色
		Role role1 = new Role();
		role1.setRname("经理");
		Role role2 = new Role();
		role2.setRname("助理");
		Role role3 = new Role();
		role3.setRname("前台");

		// 设置关系：
		user1.getRoles().add(role2);
		user1.getRoles().add(role3);

		user2.getRoles().add(role1);
		user2.getRoles().add(role2);

		role1.getUsers().add(user2);
		role2.getUsers().add(user1);
		role2.getUsers().add(user2);
		role3.getUsers().add(user1);

		session.save(user1);
		session.save(user2);
		session.save(role1);
		session.save(role2);
		session.save(role3);

		tx.commit();
	}
	@Test
	public void test07() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		// 保存两个用户:
		User user1 = new User();
		user1.setUsername("张三");
		User user2 = new User();
		user2.setUsername("李四");

		// 保存三个角色
		Role role1 = new Role();
		role1.setRname("经理");
		Role role2 = new Role();
		role2.setRname("助理");
		Role role3 = new Role();
		role3.setRname("前台");

		// 设置关系：
		user1.getRoles().add(role2);
		user1.getRoles().add(role3);

		user2.getRoles().add(role1);
		user2.getRoles().add(role2);

		role1.getUsers().add(user2);
		role2.getUsers().add(user1);
		role2.getUsers().add(user2);
		role3.getUsers().add(user1);

		session.save(user1);
		session.save(user2);
//		session.save(role1);
//		session.save(role2);
//		session.save(role3);

		tx.commit();
	}
	
	@Test
	// 将2号用户中的1号角色去掉.
	public void demo08(){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		// 查询2号用户：
		User user = session.get(User.class, 29l);
		// 查询1号角色
		Role role = session.get(Role.class, 34l);
		
		// 操作集合 相当于 操作中间表.
		user.getRoles().remove(role);
		
		tx.commit();
	}
}
