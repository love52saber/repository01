package crm_01.dao.impl;

import org.hibernate.Session;
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

}
