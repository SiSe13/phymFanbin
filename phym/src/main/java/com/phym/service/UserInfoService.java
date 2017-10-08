package com.phym.service;

import com.phym.entity.UserInfo;
import com.phym.exception.UserInfoException;

public interface UserInfoService {
	
	//通过用户id查询完善资料
	public UserInfo findUserInfoByUserId(String userId) throws UserInfoException;
	//更新完善资料
	public Boolean updateUserInfo(UserInfo userInfo) throws UserInfoException;
}
