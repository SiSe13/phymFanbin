package com.phym.service;

import java.util.List;
import java.util.Map;

import com.phym.entity.User;
import com.phym.exception.NameException;
import com.phym.exception.PasswordException;
import com.phym.exception.PhoneException;
import com.phym.exception.UserException;


public interface UserService {
	//广告登录
	public User GGlogin(String name,String password)throws UserException,NameException,PasswordException;
	//媒体登录
	public User MTlogin(String name,String password)throws UserException,NameException,PasswordException;
	//忘记密码检查手机是否被注册
	public User checkPhone(String phone)throws NameException,PhoneException;
	//注册检查手机是否被注册
	public User checkPhone_r(String phone)throws NameException,PhoneException;
	
	//修改密码
	public User updatePassword(String phone,String auth_code,String password,String rePassword)throws
				UserException,PasswordException;
	//检查用户名	 
	public Object checkName(String name)throws NameException,UserException;
	//注册用户
	public User regist(String name,String phone,String password,String confirm,int type,String number)throws
				UserException,NameException,PasswordException;
	
	//修改用户状态
	public Boolean modifyStatus(String userId,int userStatus)throws UserException;
	//通过id查询用户
	public User findUserById(String userId)throws UserException;
	//删除用户
	public Boolean deleteUser(String userId);
	//详情
	public Map<Object,Object> userParticulars(String userId);
	//查询所有用户
	public List<User> selectAllUser();
	
	//根据用户修改密码
	public Boolean updatePwd(String user_nickname,String user_password,String newpass,String newpassAgain)throws UserException,NameException,PasswordException;

	//检测代理商编码是否正确
	public Boolean checkNumber(String number);
	
}
