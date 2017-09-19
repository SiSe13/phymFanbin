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
	 * ý������¼ 
	 */
	public User media(String name, String password) throws NameException,PasswordException,UserExitException{
			if(name ==null || name.trim().isEmpty()) {
				throw new NameException("�û�������Ϊ��");
			}
			if(password ==null || password.trim().isEmpty()) {
				throw new PasswordException("���벻��Ϊ��");
			}
			User user = userdao.findUserByName(name);
			if(user == null) {
			
				throw new UserExitException("�û������������");
			}
			/*if(user.getUser_state()!=0){
				throw new UserExitException("����ȷ");
			}*/
			
			if(user.getUser_type()!=2){
				throw new UserExitException("�û����Ͳ���ȷ");
			}
			String pwd = Md5Util.md5(password+"�׻���ý");
			if(!user.getUser_password().equals(pwd)) {
				throw new PasswordException("�û������������");
			}
			
			return user;
	}
	
	/**
	 * �������¼����
	 */
	public User login(String name, String password) throws NameException,PasswordException,UserExitException{
		if(name ==null || name.trim().isEmpty()) {
			throw new NameException("�û�������Ϊ��");
		}
		if(password ==null || password.trim().isEmpty()) {
			throw new PasswordException("���벻��Ϊ��");
		}
		User user = userdao.findUserByName(name);
		if(user == null) {
			throw new UserExitException("�û������������");
		}
		String pwd = Md5Util.md5(password+"�׻���ý");
		if(!user.getUser_password().equals(pwd)) {
			throw new PasswordException("�û������������");
		}
		if(user.getUser_type()!=1){
			throw new UserExitException("�û����Ͳ���ȷ");
		}
		return user;
	}
	
	/**
	 * ��������
	 */
	public int authCode(String phone,String password,String rePassword)throws UserExitException,PasswordException{
		if(!password.equals(rePassword)){
			throw new PasswordException("ȷ�����벻��ȷ");
		}
		String pwd=Md5Util.md5(password+"�׻���ý");
		
		int n=userdao.updatePassword(phone, pwd);
		if(n!=1){
			throw new UserExitException("�޸�����ʧ��");
		}
		return n;
		
	}
	/**
	 * ע���ж��ֻ���
	 */
	public Object checkPhone(String phone) throws NameException, PhoneException {
		if(phone==null||phone.trim().isEmpty()){
			throw new PhoneException("�ֻ��Ų���Ϊ��!");
		}
		//�ֻ�������
		String reg="^1(3\\d|5[0-35-9]|8[025-9]|47)\\d{8}$";
		if(!phone.matches(reg)){
			throw new PhoneException("�ֻ�����ĸ�ʽ����ȷ");
		}
		User user=userdao.findUserByPhone(phone);
		if(user!=null){
			throw new UserExitException("�ֻ�����ע��");
		}
		return 0;
	}
	
	/**
	 * ���������ж��ֻ���
	 */
	public User changePhone(String phone) throws NameException, PhoneException {
		if(phone==null||phone.trim().isEmpty()){
			throw new PhoneException("�ֻ��Ų���Ϊ��!");
		}
		//�ֻ�������
		String reg="^1(3\\d|5[0-35-9]|8[025-9]|47)\\d{8}$";
		if(!phone.matches(reg)){
			throw new PhoneException("�ֻ�����ĸ�ʽ����ȷ");
		}
		User user=userdao.findUserByPhone(phone);
		if(user==null){
			throw new UserExitException("�û�������");
		}
		return user;
	}
		
	/**
	 * ����û���
	 */
	public Object checkName(String name)throws NameException,UserExitException{
		if(name==null||name.trim().isEmpty()){
			throw new NameException("�û�������Ϊ��!");
		}
		String regname="^[һ-��a-zA-Z][һ-��a-zA-Z0-9_]*$";
		if(!name.matches(regname)){
			throw new NameException("3-20λ�����ġ���ĸ�����֡��»��ߵ���ϣ������Ļ���ĸ��ͷ");
		}
		User user =userdao.findUserByName(name);
		if(user!=null){
			throw new UserExitException("�û����Ѵ���");
		}
		
		return 0;
	}
	
	/**
	 * ע��
	 */
	public User regist(String name, String phone, String password, String confirm,int type)
			throws UserExitException,PasswordException {
		
		if(password==null||password.trim().isEmpty()){
			throw new PasswordException("���벻��Ϊ��!");
		}
		
		if(!password.equals(confirm)){
			throw new PasswordException("ȷ�����벻��ȷ");
		}
		
		String userid = Md5Util.createId();
		String pwd=Md5Util.md5(password+"�׻���ý");
		String userInfoId = Md5Util.createId();
		
		//0Ϊ����
		int state=0;
		Timestamp createTime=new Timestamp(System.currentTimeMillis());
		
		if(userdao.findUserByName(name)!=null||userdao.findUserByPhone(phone)!=null){
			throw new RuntimeException("ע��ʧ��!");
		}
		User user =new User(userid,name,pwd,type,state,createTime,phone);
		userdao.saveUser(user);
		userdao.insertUserInfo(userInfoId, userid);
		return user;
	}
}
