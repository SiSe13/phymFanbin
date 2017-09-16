package com.phym.service;

import com.phym.entity.UserInfo;
import com.phym.exception.UserInfoExitException;

public interface UserInfoService {
	
	boolean updateUserInfo(UserInfo userInfo)throws UserInfoExitException;

}
