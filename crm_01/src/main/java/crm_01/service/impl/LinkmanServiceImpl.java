package crm_01.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm_01.dao.CustomerDao;
import crm_01.dao.LinkmanDao;
import crm_01.model.Customer;
import crm_01.model.Linkman;
import crm_01.service.LinkmanService;
import crm_01.utils.HibernateUtils;

@Service
public class LinkmanServiceImpl implements LinkmanService {
	@Autowired
	private LinkmanDao linkmanDao;
	@Autowired
	private CustomerDao customerDao;

	@Override
	public List<Linkman> listLinkman() {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<Linkman> linkmanList = new ArrayList<>();
		try {
			linkmanList = linkmanDao.queryLinkmanList();
		} catch (Exception e) {
			e.printStackTrace();
			tx.commit();
		}
		tx.commit();
		return linkmanList;
	}

	@Override
	public void saveLinkman(Linkman linkman) {
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();

		try {
			Long cust_id = linkman.getCust_id();
			Customer customer = customerDao.queryCustomerById(cust_id);
			
			linkman.setCustomer(customer);
			customer.getLinkmans().add(linkman);
			linkmanDao.saveLinkman(linkman);
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		tx.commit();
	}

	private void getCust_id() {
		// TODO Auto-generated method stub

	}
}
