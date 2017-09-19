package com.phym.service.Impl;

import java.sql.Timestamp;

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
			throw new UserInfoExitException("Id����");
		}
		if(userInfo.getName().length()>20){
			throw new UserInfoExitException("��������");
		}
		if(userInfo.getTel().length()>15){
			throw new UserInfoExitException("�������");
		}
		if(userInfo.getAddr().length()>100){
			throw new UserInfoExitException("��ַ����");
		}
		if(userInfo.getEmail()!=null){
			if(userInfo.getEmail().length()>20){
				throw new UserInfoExitException("��ַ����");
			}
			String reg="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
			if(!userInfo.getEmail().matches(reg)){
				throw new UserInfoExitException("�����ʽ����");
			}
		}
		
		if(userInfo.getCompany().length()>15){
			throw new UserInfoExitException("��˾���ֹ���");
		}
		
		
		
		userInfo.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		int n=userinfodao.updateUserInfo(userInfo);
		
		if(n==1){
			return true;
		}
		return false;
	}

}
