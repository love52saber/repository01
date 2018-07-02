package crm_01.model;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private Long rid;
	private String rname;
	
	// 一个角色中有多个所属的用户:
	private Set<User> users = new HashSet<User>();

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
}
