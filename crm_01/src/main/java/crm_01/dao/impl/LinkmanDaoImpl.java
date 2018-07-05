package crm_01.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import crm_01.dao.LinkmanDao;
import crm_01.model.Linkman;
import crm_01.utils.HibernateUtils;

@Repository
public class LinkmanDaoImpl implements LinkmanDao{

	@Override
	public List<Linkman> queryLinkmanList() {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = session.createCriteria(Linkman.class);
		return criteria.list();
	}

	@Override
	public void saveLinkman(Linkman linkman) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(linkman);
	}

}
