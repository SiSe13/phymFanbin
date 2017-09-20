package com.phym.service.Impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phym.dao.UserDao;
import com.phym.entity.User;
import com.phym.exception.NameException;
import com.phym.exception.PasswordException;
import com.phym.exception.PhoneException;
import com.phym.exception.UserExitException;
import com.phym.service.UserService;
import com.phym.util.Md5Util;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userdao;
	
	/**
	 * 媒体主登录 
	 */
	public User media(String name, String password) throws NameException,PasswordException,UserExitException{
			if(name ==null || name.trim().isEmpty()) {
				throw new NameException("用户名不能为空");
			}
			if(password ==null || password.trim().isEmpty()) {
				throw new PasswordException("密码不能为空");
			}
			User user = userdao.findUserByName(name);
			if(user == null) {
				throw new UserExitException("用户名或密码错误");
			}
			/*if(user.getUser_state()!=0){
				throw new UserExitException("不正确");
			}*/
			
			if(user.getUser_type()!=2){
				throw new UserExitException("用户类型不正确");
			}
			String pwd = Md5Util.md5(password+"谱华云媒");
			if(!user.getUser_password().equals(pwd)) {
				throw new PasswordException("用户名或密码错误");
			}
			
			return user;
	}
	
	/**
	 * 广告主登录功能
	 */
	public User login(String name, String password) throws NameException,PasswordException,UserExitException{
		if(name ==null || name.trim().isEmpty()) {
			throw new NameException("用户名不能为空");
		}
		if(password ==null || password.trim().isEmpty()) {
			throw new PasswordException("密码不能为空");
		}
		User user = userdao.findUserByName(name);
		if(user == null) {
			throw new UserExitException("用户名或密码错误");
		}
		String pwd = Md5Util.md5(password+"谱华云媒");
		if(!user.getUser_password().equals(pwd)) {
			
			throw new PasswordException("用户名或密码错误");
		}
		if(user.getUser_type()!=1){
			throw new UserExitException("用户类型不正确");
		}
		return user;
	}
	
	/**
	 * 忘记密码
	 */
	public int authCode(String phone,String password,String rePassword)throws UserExitException,PasswordException{
		if(!password.equals(rePassword)){
			throw new PasswordException("确认密码不正确");
		}
		String pwd=Md5Util.md5(password+"谱华云媒");
		
		int n=userdao.updatePassword(phone, pwd);
		if(n!=1){
			throw new UserExitException("修改密码失败");
		}
		return n;
		
	}
	/**
	 * 注册判断手机号
	 */
	public Object checkPhone(String phone) throws NameException, PhoneException {
		if(phone==null||phone.trim().isEmpty()){
			throw new PhoneException("手机号不能为空!");
		}
		//手机号正则
		String reg="^1(3\\d|5[0-35-9]|8[025-9]|47)\\d{8}$";
		if(!phone.matches(reg)){
			throw new PhoneException("手机号码的格式不正确");
		}
		User user=userdao.findUserByPhone(phone);
		if(user!=null){
			throw new UserExitException("手机号已注册");
		}
		return 0;
	}
	
	/**
	 * 忘记密码判断手机号
	 */
	public User changePhone(String phone) throws NameException, PhoneException {
		if(phone==null||phone.trim().isEmpty()){
			throw new PhoneException("手机号不能为空!");
		}
		//手机号正则
		String reg="^1(3\\d|5[0-35-9]|8[025-9]|47)\\d{8}$";
		if(!phone.matches(reg)){
			throw new PhoneException("手机号码的格式不正确");
		}
		User user=userdao.findUserByPhone(phone);
		if(user==null){
			throw new UserExitException("用户不存在");
		}
		return user;
	}
		
	/**
	 * 检查用户名
	 */
	public Object checkName(String name)throws NameException,UserExitException{
		if(name==null||name.trim().isEmpty()){
			throw new NameException("用户名不能为空!");
		}
		String regname="^[一-龥a-zA-Z][一-龥a-zA-Z0-9_]*$";
		if(!name.matches(regname)){
			throw new NameException("3-20位，中文、字母、数字、下划线的组合，以中文或字母开头");
		}
		User user =userdao.findUserByName(name);
		if(user!=null){
			throw new UserExitException("用户名已存在");
		}
		
		return 0;
	}
	
	/**
	 * 注册
	 */
	public User regist(String name, String phone, String password, String confirm,int type)
			throws UserExitException,PasswordException {
		
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空!");
		}
		
		if(!password.equals(confirm)){
			throw new PasswordException("确认密码不正确");
		}
		
		String userid = Md5Util.createId();
		String pwd=Md5Util.md5(password+"谱华云媒");
		String userInfoId = Md5Util.createId();
		
		//0为正常
		int state=0;
		Timestamp createTime=new Timestamp(System.currentTimeMillis());
		
		if(userdao.findUserByName(name)!=null||userdao.findUserByPhone(phone)!=null){
			throw new RuntimeException("注册失败!");
		}
		User user =new User(userid,name,pwd,type,state,createTime,phone);
		userdao.saveUser(user);
		userdao.insertUserInfo(userInfoId, userid);
		return user;
	}
}
