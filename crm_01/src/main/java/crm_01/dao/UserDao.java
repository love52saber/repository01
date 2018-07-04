package crm_01.dao;

import crm_01.model.User;

public interface UserDao {

	User queryUserByUsernameAndPassword(String username, String password);

}
