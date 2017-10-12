package com.phym.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.AgencyDao;
import com.phym.entity.Agency;
import com.phym.entity.ChannelManager;
import com.phym.entity.Serial;
import com.phym.exception.AgencyException;
import com.phym.util.NoteUtil;
@Service("agencyService")
public class AgencyServiceImpl implements AgencyService {
	
	@Autowired
	private AgencyDao dao;
	@Autowired
	private SerialService serialService;
	@Autowired
	private ChannelManagerService managerService;
	
	//添加代理商
	public Boolean insertAgency(Agency agency) throws AgencyException{
		if(agency ==null) {
			throw new AgencyException("参数错误");
		}
		String name = agency.getName();
		int level = agency.getLevel();
		String phone = agency.getPhone();
		String province = agency.getProvince();
		String city = agency.getCity();
		String area = agency.getArea();
		String manager = agency.getManager();
		int status = agency.getStatus();
		
		if(name.equals("")||name.isEmpty()||name==null) {
			throw new AgencyException("用户名不能为空");
		}
		String regname="^[一-龥a-zA-Z][一-龥a-zA-Z0-9_]*$";
		if(!name.matches(regname)){
			throw new AgencyException("3-20位，中文、字母、数字、下划线的组合，以中文或字母开头");
		}
		if(level<0) {
			throw new AgencyException("123");
		}
		if(phone==null||phone.isEmpty()||phone.equals("")) {
			throw new AgencyException("请输入手机号");
		}
		//手机号正则
		String reg="^1(3\\d|5[0-35-9]|8[025-9]|47)\\d{8}$";
		if(!phone.matches(reg)){
			throw new AgencyException("手机号码的格式不正确");
		}
		if(province==null||province.isEmpty()||province.equals("")) {
			throw new AgencyException("请选择省");
		}
		if(city==null||city.isEmpty()||city.equals("")) {
			throw new AgencyException("请选择市");
		}
		if(area==null||area.isEmpty()||area.equals("")) {
			throw new AgencyException("请选择区/县");
		}
		if(manager==null||manager.isEmpty()||manager.equals("")) {
			throw new AgencyException("请填写区域经理");
		}
		ChannelManager man = managerService.findManagerByName(manager);
		if(man==null) {
			throw new AgencyException("请输入正确的经理人");
		}
		agency.setId(NoteUtil.createId());
		String pwd = NoteUtil.md5("123456a"+"谱华云媒");
		agency.setPassword(pwd);
		List<Serial> list = serialService.findAllSerial();
		if(list.isEmpty()) {
			throw new AgencyException("网络延迟");
		}
		String number = list.get(0).getNumber();
		if(number==null||number.isEmpty()||number.equals("")) {
			throw new AgencyException("获取编号失败");
		}
		Boolean bool = serialService.updateSerialStatus(number);
		if(!bool) {
			throw new AgencyException("更新代理商编号失败");
		}
		agency.setCode(number);
		agency.setBalance(0);
		agency.setDeposit(0);
		agency.setCreateTime(new Timestamp(System.currentTimeMillis()));
		agency.setStatus(status);
		int n = dao.insertAgency(agency);
		if(n!=1) {
			throw new AgencyException("添加代理商失败");
		}
		return true;
	}
	//通过id查询代理商
	public Agency findAgencyById(String id) throws AgencyException{
		if(id ==null||id.isEmpty()||id.equals("")) {
			throw new AgencyException("错误的ID");
		}
		Agency agency = dao.findAgencyById(id);
		if(agency ==null) {
			throw new AgencyException("网络延迟");
		}
		
		return agency;
	}
	//查询所有的代理商
	public List<Agency> findAllAgency() throws AgencyException{
		List<Agency> list = dao.findAllAgency();
		if(list.isEmpty()) {
			throw new AgencyException("暂无代理商数据");
		}
		
		return list;
	}
	//通过id删除代理商
	public Boolean deleteAgencyById(String id) throws AgencyException{
		if(id ==null||id.isEmpty()||id.equals("")) {
			throw new AgencyException("错误的ID");
		}
		int n = dao.deleteAgencyById(id);
		if(n !=1) {
			throw new AgencyException("删除代理商失败");
		}
		
		return true;
	}
	//代理商登录
	public Agency agencyLogin(String name, String password) throws AgencyException{
		if(name==null||name.isEmpty()||name.equals("")) {
			throw new AgencyException("请输入用户名");
		}
		if(password ==null||password.isEmpty()||password.equals("")) {
			throw new AgencyException("请输入密码");
		}
		Agency agency = dao.findAgencyByName(name);
		if(agency==null) {
			throw new AgencyException("用户名不存在");
		}
		String pwd = NoteUtil.md5(password+"谱华云媒");
		if(!agency.getPassword().equals(pwd)) {
			throw new AgencyException("用户名或密码错误");
		}
		
		return agency;
	}
	//通过代理商编号查询代理商
	public Agency findAgencyByCode(String code) throws AgencyException {
		if(code ==null || code.isEmpty()||code.equals("")) {
			throw new AgencyException("错误的编号");
		}
		Agency agency = dao.findAgencyByCode(code);
		if(agency ==null) {
			throw new AgencyException("请输入正确的代理商编号，或者填写默认0000编号");
		}
		return agency;
	}
	
}
