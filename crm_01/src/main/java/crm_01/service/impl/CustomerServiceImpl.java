package crm_01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm_01.dao.CustomerDao;
import crm_01.model.Customer;
import crm_01.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	public void save(Customer customer) {
		customerDao.save(customer);
	}

}
