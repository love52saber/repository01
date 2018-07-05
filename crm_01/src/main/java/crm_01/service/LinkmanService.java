package crm_01.service;

import java.util.List;

import crm_01.model.Linkman;

public interface LinkmanService {

	List<Linkman> listLinkman();

	void saveLinkman(Linkman linkman);

}
