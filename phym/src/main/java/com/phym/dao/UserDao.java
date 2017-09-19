package com.phym.dao;

import org.apache.ibatis.annotations.Param;

import com.phym.entity.User;

public interface UserDao {
	//����һ���û�
	 int saveUser(User user);
	
	//�����û����鿴�û�
	 User findUserByName(String name);
	
	//�����ֻ��Ų�ѯ�û�
	 User findUserByPhone(String phone);
	 
	 //�����ֻ����޸�����
	 int updatePassword(@Param("phone") String phone,@Param("password") String password);
	 
	 //�����������ϱ�
	 int insertUserInfo(@Param("id") String id,@Param("userId") String userId);
	 
	 //����userId ��ѯ��Ϣ
	 User findUserById(String userId);
}
