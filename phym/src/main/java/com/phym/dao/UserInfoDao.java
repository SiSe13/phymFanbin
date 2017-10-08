package com.phym.dao;

import com.phym.entity.UserInfo;

public interface UserInfoDao {
	//更新完善资料
	public int updateUserInfo(UserInfo userInfo);
	//通过用户ID查询完善资料
	public UserInfo findUserInfoByUserId(String userId);
	
}
