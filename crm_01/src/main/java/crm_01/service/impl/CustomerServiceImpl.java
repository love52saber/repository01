package crm_01.service.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm_01.dao.CustomerDao;
import crm_01.model.Customer;
import crm_01.service.CustomerService;
import crm_01.utils.HibernateUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public void save(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			customerDao.save(customer);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
	}

	@Override
	public List<Customer> listAll(DetachedCriteria detachedCriteria) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Customer> customerList = customerDao.listAll(detachedCriteria);
		tx.commit();
		return customerList;
	}

	@Override
	public Customer queryCustomerById(Long cust_id) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		Customer customer = customerDao.queryCustomerById(cust_id);
		tx.commit();
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		customerDao.updateCustomer(customer);
		tx.commit();
	}

	@Override
	public void delCustomer(Customer customer) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		customerDao.delCustomer(customer);
		tx.commit();
	}

}
