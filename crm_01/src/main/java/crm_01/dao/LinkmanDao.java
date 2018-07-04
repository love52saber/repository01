package crm_01.dao;

import java.util.List;

import crm_01.model.Linkman;

public interface LinkmanDao {

	List<Linkman> queryLinkmanList();
	
	void saveLinkman(Linkman linkman);
	
}
