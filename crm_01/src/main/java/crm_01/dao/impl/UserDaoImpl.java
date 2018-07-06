package crm_01.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import crm_01.dao.UserDao;
import crm_01.model.User;
import crm_01.utils.HibernateUtils;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public User queryUserByUsernameAndPassword(String username, String password) {
		
		Session session = HibernateUtils.getCurrentSession();
		
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		criteria.add(Restrictions.eq("password", password));
		
		User existUser = (User) criteria.uniqueResult();
		
		return existUser;
	}

	@Override
	public void add() {
		System.out.println("add");
	}


}
