package com.phym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.UserInfoDao;
import com.phym.entity.UserInfo;
import com.phym.exception.UserInfoException;
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private UserInfoDao infoDao;
	
	//根据用户id查询完善资料
	public UserInfo findUserInfoByUserId(String userId) throws UserInfoException{
		if(userId ==null || userId.trim().isEmpty()) {
			throw new UserInfoException("错误的ID");
		}
		UserInfo info = infoDao.findUserInfoByUserId(userId);
		if(info ==null) {
			throw new UserInfoException("网络延迟");
		}
		
		return info;
	}
	
	//完善用户资料
	public Boolean updateUserInfo(UserInfo userInfo) throws UserInfoException{
		if(userInfo ==null) {
			throw new UserInfoException("网络延迟");
		}
		String userId = userInfo.getUserId();
		if(userId ==null ||userId.trim().isEmpty()) {
			throw new UserInfoException("错误的ID");
		}
		UserInfo info = infoDao.findUserInfoByUserId(userId);
		String name = userInfo.getName();
		String tel = userInfo.getTel();
		String addr = userInfo.getAddr();
		String email = userInfo.getEmail();
		String company = userInfo.getCompany();
		String headimg = userInfo.getHeadimg();
		String str = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$"; // 邮箱正则
		String strs = "^(0[0-9]{2,3}\\-)?([2-9][0-9]{6,7})$";
		
		if(!"".equals(email) && !email.matches(str)) {
			throw new UserInfoException("邮箱格式不正确");
		}
		if(!"".equals(tel) && !tel.matches(strs)) {
			throw new UserInfoException("固话格式不正确");
		}
		
		if(info.getName().equals(name)) {
			name = null;
		}
		if(tel.equals(info.getTel())) {
			tel = null;
		}
		if(info.getAddr().equals(addr)) {
			addr = null;
		}
		if(email.equals(info.getEmail())) {
			email = null;
		}
		if(company.equals(info.getCompany())) {
			company = null;
		}
		if(headimg.equals(info.getHeadimg())) {
			headimg = null;
		}
		int n=infoDao.updateUserInfo(userInfo);
		if(n!=1){
			throw new UserInfoException("网络异常");
		}
		return true;
	}

}
