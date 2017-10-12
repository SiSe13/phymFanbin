package com.phym.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.phym.entity.User;

public interface UserDao {
	//创建一个用户

	public int saveUser(User user);
	
	//通过手机查找用户
	public User findUserByPhone(String phone);
	
	//通过用户名 查找用户
	public User findUserByName(String name);
	
	//更新密码
	public int updatePassword(@Param("phone") String phone,@Param("password") String password);
	
	//插入完善资料
	public int insertUserInfo(@Param("id") String id,@Param("userId") String userId);
	
	//通过id查询用户
	public User findUserById(String userId);
	
	//修改用户状态
	public int modifyStatus(@Param("userId") String userId,@Param("userStatus") int userStatus);
	
	//删除用户
	public int deleteUser(String userId);
	
	//详情
	public Map<Object,Object> userParticulars(String userId);
	
	//查询所有用户
	public List<User> selectAllUser();
	
	//根据用户名修改密码
	public int updatePwd(@Param("user_nickname") String user_nickname,@Param("newpass") String newpass);
	
	//退出
	public boolean updateLastlogTime(User user);
	
}
