package com.phym.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class User implements Serializable {
	private static final long serialVersionUID = 7254732736428890863L;
	
	private String user_id;         //id
	private String user_nickname;	//用户名
	private String user_password;   //密码
	private int user_type;    	//用户类型、广告、媒体
	private int user_state;			//状态
	private Timestamp user_create_time;  	//创建用户时间  
	private Timestamp user_update_time;		//更新时间
	private String user_Phone_num;    		//手机号
	private Timestamp user_lastlog_time;	//最后登录时间
	private String user_level;				//媒体主等级
	private String user_demo; 				//闲置
	
	public User() {
		
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_Phone_num == null) ? 0 : user_Phone_num.hashCode());
		result = prime * result + ((user_create_time == null) ? 0 : user_create_time.hashCode());
		result = prime * result + ((user_demo == null) ? 0 : user_demo.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		result = prime * result + ((user_lastlog_time == null) ? 0 : user_lastlog_time.hashCode());
		result = prime * result + ((user_level == null) ? 0 : user_level.hashCode());
		result = prime * result + ((user_nickname == null) ? 0 : user_nickname.hashCode());
		result = prime * result + ((user_password == null) ? 0 : user_password.hashCode());
		result = prime * result + user_state;
		result = prime * result + user_type;
		result = prime * result + ((user_update_time == null) ? 0 : user_update_time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_Phone_num == null) {
			if (other.user_Phone_num != null)
				return false;
		} else if (!user_Phone_num.equals(other.user_Phone_num))
			return false;
		if (user_create_time == null) {
			if (other.user_create_time != null)
				return false;
		} else if (!user_create_time.equals(other.user_create_time))
			return false;
		if (user_demo == null) {
			if (other.user_demo != null)
				return false;
		} else if (!user_demo.equals(other.user_demo))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		if (user_lastlog_time == null) {
			if (other.user_lastlog_time != null)
				return false;
		} else if (!user_lastlog_time.equals(other.user_lastlog_time))
			return false;
		if (user_level == null) {
			if (other.user_level != null)
				return false;
		} else if (!user_level.equals(other.user_level))
			return false;
		if (user_nickname == null) {
			if (other.user_nickname != null)
				return false;
		} else if (!user_nickname.equals(other.user_nickname))
			return false;
		if (user_password == null) {
			if (other.user_password != null)
				return false;
		} else if (!user_password.equals(other.user_password))
			return false;
		if (user_state != other.user_state)
			return false;
		if (user_type != other.user_type)
			return false;
		if (user_update_time == null) {
			if (other.user_update_time != null)
				return false;
		} else if (!user_update_time.equals(other.user_update_time))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_nickname=" + user_nickname + ", user_password=" + user_password
				+ ", user_type=" + user_type + ", user_state=" + user_state + ", user_create_time=" + user_create_time
				+ ", user_update_time=" + user_update_time + ", user_Phone_num=" + user_Phone_num
				+ ", user_lastlog_time=" + user_lastlog_time + ", user_level=" + user_level + ", user_demo=" + user_demo
				+ "]";
	}

	
}