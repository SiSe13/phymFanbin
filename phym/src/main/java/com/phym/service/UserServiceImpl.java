package com.phym.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.UserDao;
import com.phym.entity.User;
import com.phym.exception.CodeException;
import com.phym.exception.NameException;
import com.phym.exception.PasswordException;
import com.phym.exception.PhoneException;
import com.phym.exception.UserException;


import com.phym.util.NoteUtil;
@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;
	//广告登录
	public User GGlogin(String name, String password) throws NameException,PasswordException,UserException{
		if(name ==null || name.trim().isEmpty()) {
			throw new NameException("用户名不能为空");
		}
		if(password ==null || password.trim().isEmpty()) {
			throw new PasswordException("密码不能为空");
		}
		
		User user = dao.findUserByName(name);
		
		if(user == null) {
			throw new UserException("用户名或密码错误");
		}
		String pwd = NoteUtil.md5(password+"谱华云媒");
		if(!user.getUser_password().equals(pwd)) {
			throw new PasswordException("用户名或密码错误");
		}
		if(user.getUser_type() != 1) {
			throw new UserException("请登录广告账户");
		}
		
		return user;
	}
	//媒体登录
	public User MTlogin(String name, String password) throws UserException, NameException, PasswordException {
		if(name ==null || name.trim().isEmpty()) {
			throw new NameException("用户名不能为空");
		}
		if(password ==null || password.trim().isEmpty()) {
			throw new PasswordException("密码不能为空");
		}
		User user = dao.findUserByName(name);
		if(user == null) {
			throw new UserException("用户名或密码错误");
		}
		
		String pwd = NoteUtil.md5(password+"谱华云媒");
		if(!user.getUser_password().equals(pwd)) {
			throw new PasswordException("用户名或密码错误");
		}
		if(user.getUser_type() != 2) {
			throw new UserException("请登录媒体账户");
		}
		
		return user;
		
	}
	//修改密码检测手机
	public User checkPhone(String phone) throws PhoneException,UserException{
		
		if(phone =="" ||phone.trim().isEmpty()) {
			throw new PhoneException("手机号不能为空");
		}
		//手机号正则
		String reg="^1(3\\d|5[0-35-9]|8[025-9]|47)\\d{8}$";
		if(!phone.matches(reg)){
			throw new PhoneException("手机号码的格式不正确");
		}				
		User user = dao.findUserByPhone(phone);
		if(user ==null) {
			throw new UserException("此手机号未注册账户");
		}
		return user;
	}
	//注册检测手机
	public User checkPhone_r(String phone) throws PhoneException,UserException{
		if(phone =="" ||phone.trim().isEmpty()) {
			throw new PhoneException("手机号不能为空");
		}
		//手机号正则
		String reg="^1(3\\d|5[0-35-9]|8[025-9]|47)\\d{8}$";
		if(!phone.matches(reg)){
			throw new PhoneException("手机号码的格式不正确");
		}
		
		User user = dao.findUserByPhone(phone);
		if(user != null) {
			throw new UserException("手机号已被注册");
		}
		return user;
	}
	
	////修改密码	
	public User updatePassword(String phone, String auth_code, String password, String rePassword)
				throws PhoneException,CodeException,PasswordException{
		if(phone =="" ||phone.trim().isEmpty()) {
			throw new PhoneException("手机号不能为空");
		}
		if(auth_code=="" ||auth_code.trim().isEmpty()) {
			throw new CodeException("请输入验证码"); 
		}
		if(password==""||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空!");
		}
		if(rePassword==""||rePassword.trim().isEmpty()){
			throw new PasswordException("确认密码不能为空!");
		}
		if(!password.equals(rePassword)) {
			throw new PasswordException("两次密码输入不一致");
		}
		//手机号正则
		String reg="^1(3\\d|5[0-35-9]|8[025-9]|47)\\d{8}$";
				   
		if(!phone.matches(reg)){
				throw new PhoneException("手机号码的格式不正确");
			}
				
		User user = dao.findUserByPhone(phone);
		String pwd = NoteUtil.md5(password+"谱华云媒");
		user.setUser_update_time(new Timestamp(System.currentTimeMillis()));
		user.setUser_password(pwd);										
		return user;
	}
	//检查用户名
	public Object checkName(String name)throws NameException,UserException{
		if(name==null||name.trim().isEmpty()){
			throw new NameException("用户名不能为空!");
		}
		String regname="^[一-龥a-zA-Z][一-龥a-zA-Z0-9_]*$";
		if(!name.matches(regname)){
			throw new NameException("3-20位，中文、字母、数字、下划线的组合，以中文或字母开头");
		}
		User user =dao.findUserByName(name);
		if(user!=null){
			throw new UserException("用户名已存在");
		}
		return 0;

	}
	
	//注册
	public User regist(String name, String phone, String password, String confirm,int type)
			throws UserException,PasswordException {
		
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("密码不能为空!");
		}
		
		if(!password.equals(confirm)){
			throw new PasswordException("确认密码不正确");
		}
		
		String userid = NoteUtil.createId();
		String pwd=NoteUtil.md5(password+"谱华云媒");
		String userInfoId = NoteUtil.createId();
		
		//0为正常
		int state=0;
		Timestamp createTime=new Timestamp(System.currentTimeMillis());
		
		if(dao.findUserByName(name)!=null||dao.findUserByPhone(phone)!=null){
			throw new RuntimeException("注册失败!");
		}
		User user =new User(userid,name,pwd,type,state,createTime,phone);
		dao.saveUser(user);
		dao.insertUserInfo(userInfoId, userid);
		return user;
	}
	
	//修改用户状态
	public Boolean modifyStatus(String userId, int userStatus) throws UserException {
		if(userId ==null) {
			throw new UserException("无法修改,ID为null");
		}
		
		int num = dao.modifyStatus(userId, userStatus);
		if(num != 1) {
			throw new UserException("修改状态失败");
		}
		
		return true;
	}
	//通过id查询用户
	public User findUserById(String userId) throws UserException {
		if(userId ==null) {
			throw new UserException("无效的操作,ID为null");
		}
		User user = dao.findUserById(userId);
		if(user ==null) {
			throw new UserException("网络延迟");
		}
		return user;
	}
	//删除用户
	public Boolean deleteUser(String userId) {
		if(userId==null) {
			throw new UserException("无效的操作,ID为null");
		}
		int num = dao.deleteUser(userId);
		if(num != 1) {
			throw new UserException("删除失败");
		}
		return true;
	}
	//详情
	public Map<Object, Object> userParticulars(String userId) {
		if(userId==null) {
			throw new UserException("无效的操作,ID为null");
		}
		Map<Object,Object> map = dao.userParticulars(userId);
		if(map ==null) {
			throw new UserException("网络延迟");
		}
		return map;
	}
	//查询所有用户
	public List<User> selectAllUser() {
		List<User> list = dao.selectAllUser();
		if(list ==null) {
			throw new UserException("无内容");
		}
		return list;
	}
	
	//根据用户名修改密码
		public Boolean updatePwd(String user_nickname, String user_password, String newpass, String newpassAgain)
				throws UserException, NameException, PasswordException {
			if(user_nickname =="" ||user_nickname.trim().isEmpty()) {
				throw new NameException("用户名参数为空");
			}
			if(user_password =="" ||user_password.trim().isEmpty()) {
				throw new PasswordException("请输入密码");
			}
			if(newpass =="" ||newpass.trim().isEmpty()) {
				throw new PasswordException("请输入新密码");
			}
			if(newpassAgain =="" ||newpassAgain.trim().isEmpty()) {
				throw new PasswordException("请输入确认密码");
			}
			User user = dao.findUserByName(user_nickname);
			if(user == null) {
				throw new UserException("用户不存在");
			}
			String pwd = NoteUtil.md5(user_password+"谱华云媒");
			if(!pwd.equals(user.getUser_password())) {
				throw new PasswordException("密码输入错误");
			}
			if(!newpass.equals(newpassAgain)) {
				throw new PasswordException("新密码输入不一致");
			}
			int i = dao.updatePwd(user_nickname,NoteUtil.md5(newpass+"谱华云媒") );
			if(i != 1) {
				throw new UserException("密码修改失败");
			}
			return true;
		}
	
}
