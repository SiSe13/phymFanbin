package com.phym.service;

import com.phym.entity.User;
import com.phym.exception.NameException;
import com.phym.exception.PasswordException;
import com.phym.exception.PhoneException;
import com.phym.exception.UserExitException;

public interface UserService {
	
	/**
	 * 媒体主登录
	 */
	User media(String name, String password) throws NameException,PasswordException,UserExitException;
	/**
	 * 广告主登录
	 */
	User login(String name,String password)throws UserExitException,NameException,PasswordException;
	/**
	 * 修改密码
	 */
	int authCode(String phone,String password,String rePassword)throws UserExitException,PasswordException;
	/**
	 * 注册 检查手机号
	 */
	Object checkPhone(String phone)throws NameException,PhoneException;
	
	/**
	 * 忘记密码 检测手机号
	 */
	User changePhone(String phone)throws NameException,PhoneException;
	
	/**
	 * 检查用户名
	 */
	Object checkName(String name)throws NameException,UserExitException;
	/**
	 * 注册用户
	 */
	User regist(String name,String phone,String password,String confirm,int type)throws
		UserExitException,NameException,PasswordException;
}
