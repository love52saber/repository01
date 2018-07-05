package crm_01.web;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import crm_01.model.Customer;
import crm_01.model.Linkman;
import crm_01.service.CustomerService;
import crm_01.service.LinkmanService;

@Controller
public class LinkmanAction extends BaseAction {
	
	@Autowired
	private LinkmanService linkmanService;
	@Autowired
	private CustomerService customerService;
	
	private Linkman linkman;
	
	public String listLinkman() {
		List<Linkman> linkmanList =  linkmanService.listLinkman();
		request.setAttribute("linkmanList", linkmanList);
		return "listLinkman";
	}
	
	public String toAddLinkman() {
		List<Customer> customerList = customerService.listAll(DetachedCriteria.forClass(Customer.class));
		request.setAttribute("customerList", customerList);
		return "addLinkman";
	}
	
	public String addLinkman() {
		linkmanService.saveLinkman(linkman);
		return "redirectToListlinkman";
	}

	public Linkman getLinkman() {
		return linkman;
	}

	public void setLinkman(Linkman linkman) {
		this.linkman = linkman;
	}
}
