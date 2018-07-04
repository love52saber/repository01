package crm_01.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crm_01.dao.UserDao;
import crm_01.model.User;
import crm_01.service.UserService;
import crm_01.utils.HibernateUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User login(User user){
		Session session = HibernateUtils.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		User existUser = userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
		
		if (existUser==null) {
			throw new RuntimeException("用户名或密码错误");
		}
		
		return existUser;
	}
}
