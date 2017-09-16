package com.phym.service;

import com.phym.entity.User;
import com.phym.exception.NameException;
import com.phym.exception.PasswordException;
import com.phym.exception.PhoneException;
import com.phym.exception.UserExitException;

public interface UserService {
	
	/**
	 * ý������¼
	 */
	User media(String name, String password) throws NameException,PasswordException,UserExitException;
	/**
	 * �������¼
	 */
	User login(String name,String password)throws UserExitException,NameException,PasswordException;
	/**
	 * �޸�����
	 */
	int authCode(String phone,String password,String rePassword)throws UserExitException,PasswordException;
	/**
	 * ע�� ����ֻ���
	 */
	Object checkPhone(String phone)throws NameException,PhoneException;
	
	/**
	 * �������� ����ֻ���
	 */
	User changePhone(String phone)throws NameException,PhoneException;
	
	/**
	 * ����û���
	 */
	Object checkName(String name)throws NameException,UserExitException;
	/**
	 * ע���û�
	 */
	User regist(String name,String phone,String password,String confirm,int type)throws
		UserExitException,NameException,PasswordException;
}
