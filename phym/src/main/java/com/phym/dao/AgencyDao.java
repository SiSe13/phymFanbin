package com.phym.dao;

import java.util.List;
import com.phym.entity.Agency;

public interface AgencyDao {
	//添加代理商
	public int insertAgency(Agency agency);
	//通过id查询代理商
	public Agency findAgencyById(String id);
	//查询所有的代理商
	public List<Agency> findAllAgency();
	//通过id删除代理商
	public int deleteAgencyById(String id);
	//通过用户名查找代理商
	public Agency findAgencyByName(String name);
	//通过代理商编号查询代理商
	public Agency findAgencyByCode(String code);
	
}
