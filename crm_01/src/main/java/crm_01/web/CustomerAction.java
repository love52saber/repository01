package crm_01.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import crm_01.model.Customer;
import crm_01.service.CustomerService;

@Controller
public class CustomerAction extends ActionSupport implements ServletRequestAware{
	
	@Autowired
	private CustomerService customerService;
	
	private Customer customer;
	
	private HttpServletRequest request;
	
	public String toAdd() {
		return "toAdd";
	}
	
	public String addCustomer() {
		customerService.save(customer);
		return "redirectToListCustomer";
	}
	
	public String listCustomer() {
		
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		String cust_name = customer!=null&&customer.getCust_name()!=null?customer.getCust_name():"";
		detachedCriteria.add(Restrictions.like("cust_name", "%"+cust_name+"%"));
		
		List<Customer> customerList = customerService.listAll(detachedCriteria);
		
		request.setAttribute("customerList", customerList);
		return "listCustomer";
	}
	
	public String toEditCustomer() {
		Long cust_id = customer!=null?customer.getCust_id():0L;
		Customer customer = customerService.queryCustomerById(cust_id);
		request.setAttribute("customer", customer);
		return "editCustomer";
	}
	
	public String editCustomer() {
		customerService.updateCustomer(customer);
		return "redirectToListCustomer";
	}
	
	public String delCustomer() {
		customerService.delCustomer(customer);
		return "redirectToListCustomer";
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
}
