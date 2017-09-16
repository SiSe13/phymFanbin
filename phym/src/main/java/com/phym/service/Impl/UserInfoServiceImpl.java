package com.phym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phym.dao.UserInfoDao;
import com.phym.entity.UserInfo;
import com.phym.exception.UserInfoExitException;
import com.phym.service.UserInfoService;

@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDao userinfodao;
	
	public boolean updateUserInfo(UserInfo userInfo)throws UserInfoExitException {
		if(userInfo==null){
			return false;
		}
		if(userInfo.getUserId()==null||userInfo.getUserId().trim().isEmpty()){
			throw new UserInfoExitException("Id´íÎó");
		}
		
		int n=userinfodao.updateUserInfo(userInfo);
		
		if(n==1){
			return true;
		}
		return false;
	}

}
