package com.phym.service;

import java.util.List;

import com.phym.entity.Agency;
import com.phym.exception.AgencyException;

public interface AgencyService {
	
	//添加代理商
	public Boolean insertAgency(Agency agency) throws AgencyException;
	
	//通过id查询代理商
	public Agency findAgencyById(String id) throws AgencyException;
	
	//查询所有的代理商
	public List<Agency> findAllAgency() throws AgencyException;
	
	//通过id删除代理商
	public Boolean deleteAgencyById(String id) throws AgencyException;
	
	//代理商登录
	public Agency agencyLogin(String name,String password) throws AgencyException;
	
	//通过代理商编号查询代理商
	public Agency findAgencyByCode(String code) throws AgencyException;
}
