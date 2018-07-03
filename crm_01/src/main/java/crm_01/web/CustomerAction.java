package crm_01.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import crm_01.model.Customer;
import crm_01.service.CustomerService;

@Controller
public class CustomerAction extends ActionSupport {
	
	@Autowired
	private CustomerService customerService;
	
	private Customer customer;
	
	public String toAdd() {
		return "toAdd";
	}
	
	public void addCustomer() {
		customerService.save(customer);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
