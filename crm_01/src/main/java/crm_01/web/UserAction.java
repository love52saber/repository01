package crm_01.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import crm_01.model.User;
import crm_01.service.UserService;

@Controller
public class UserAction extends BaseAction implements ModelDriven<User> {
	
	@Autowired
	private UserService userService;
	
	private User user = new User();
	
	public String login() throws Exception {
		User existUser = userService.login(user);
		request.getSession().setAttribute("existUser", existUser);
		
		return "index";
	}

	@Override
	public User getModel() {
		return user;
	}
}
