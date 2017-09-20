package com.phym.dao;

import org.apache.ibatis.annotations.Param;

import com.phym.entity.User;

public interface UserDao {
	//创建一个用户
		 int saveUser(User user);
		
		//根据用户名查看用户
		 User findUserByName(String name);
		
		//根据手机号查询用户
		 User findUserByPhone(String phone);
		 
		 //根据手机号修改密码
		 int updatePassword(@Param("phone") String phone,@Param("password") String password);
		 
		 //插入完善资料表
		 int insertUserInfo(@Param("id") String id,@Param("userId") String userId);
		 
		 //根据userId 查询信息
		 User findUserById(String userId);
}
