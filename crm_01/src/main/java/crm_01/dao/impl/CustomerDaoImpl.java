package crm_01.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import crm_01.dao.CustomerDao;
import crm_01.model.Customer;
import crm_01.utils.HibernateUtils;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Override
	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(customer);
	}

	@Override
	public List<Customer> listAll(DetachedCriteria detachedCriteria) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = detachedCriteria.getExecutableCriteria(session);
		List<Customer> customerList = criteria.list();
		return customerList;
	}

	@Override
	public Customer queryCustomerById(Long cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("cust_id", cust_id));
		Customer customer = (Customer) criteria.uniqueResult();
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		session.update(customer);
	}

	@Override
	public void delCustomer(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		session.delete(customer);
	}

}
