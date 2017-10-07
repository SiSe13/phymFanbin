package com.phym.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4126149258159117726L;
	private String user_id; //用户id
	private String user_nickname; //用户昵称
	private String user_password;//密码
	private int user_type;//用户归属（1广告/2媒体）
	private int user_state;//用户状态（1正常/2冻结）
	private Timestamp user_create_time;//创建时间
	private Timestamp user_update_time;//更新时间
	private String user_Phone_num;//手机
	private Timestamp user_lastlog_time;//最后退出时间
	private String user_level;//媒体主等级
	private String user_demo;//代理商编号
	private UserInfo userInfo;
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public int getUser_type() {
		return user_type;
	}
	public void setUser_type(int user_type) {
		this.user_type = user_type;
	}
	public int getUser_state() {
		return user_state;
	}
	public void setUser_state(int user_state) {
		this.user_state = user_state;
	}
	public Timestamp getUser_create_time() {
		return user_create_time;
	}
	public void setUser_create_time(Timestamp user_create_time) {
		this.user_create_time = user_create_time;
	}
	public Timestamp getUser_update_time() {
		return user_update_time;
	}
	public void setUser_update_time(Timestamp user_update_time) {
		this.user_update_time = user_update_time;
	}
	public String getUser_Phone_num() {
		return user_Phone_num;
	}
	public void setUser_Phone_num(String user_Phone_num) {
		this.user_Phone_num = user_Phone_num;
	}
	public Timestamp getUser_lastlog_time() {
		return user_lastlog_time;
	}
	public void setUser_lastlog_time(Timestamp user_lastlog_time) {
		this.user_lastlog_time = user_lastlog_time;
	}
	public String getUser_level() {
		return user_level;
	}
	public void setUser_level(String user_level) {
		this.user_level = user_level;
	}
	public String getUser_demo() {
		return user_demo;
	}
	public void setUser_demo(String user_demo) {
		this.user_demo = user_demo;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String user_id, String user_nickname, String user_password, int user_type, int user_state,
			Timestamp user_create_time, Timestamp user_update_time, String user_Phone_num, Timestamp user_lastlog_time,
			String user_level, String user_demo) {
		super();
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.user_password = user_password;
		this.user_type = user_type;
		this.user_state = user_state;
		this.user_create_time = user_create_time;
		this.user_update_time = user_update_time;
		this.user_Phone_num = user_Phone_num;
		this.user_lastlog_time = user_lastlog_time;
		this.user_level = user_level;
		this.user_demo = user_demo;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_nickname=" + user_nickname + ", user_password=" + user_password
				+ ", user_type=" + user_type + ", user_state=" + user_state + ", user_create_time=" + user_create_time
				+ ", user_update_time=" + user_update_time + ", user_Phone_num=" + user_Phone_num
				+ ", user_lastlog_time=" + user_lastlog_time + ", user_level=" + user_level + ", user_demo=" + user_demo
				+ "]";
	}
	public User(String user_id, String user_nickname, String user_password, int user_type, int user_state,
			Timestamp user_create_time, String user_Phone_num) {
		super();
		this.user_id = user_id;
		this.user_nickname = user_nickname;
		this.user_password = user_password;
		this.user_type = user_type;
		this.user_state = user_state;
		this.user_create_time = user_create_time;
		this.user_Phone_num = user_Phone_num;
	}
	
	
	
	
	
	
}
