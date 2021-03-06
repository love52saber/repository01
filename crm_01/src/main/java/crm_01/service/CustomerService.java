package crm_01.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import crm_01.model.Customer;

public interface CustomerService {
	
	public void save(Customer customer);
	
	public List<Customer> listAll(DetachedCriteria detachedCriteria);

	public Customer queryCustomerById(Long cust_id);

	public void updateCustomer(Customer customer);

	public void delCustomer(Customer customer);
}
