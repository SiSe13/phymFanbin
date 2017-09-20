package com.phym.dao;

import com.phym.entity.Message;

public interface MessageDao {
	
	//查询所有信息
	Message findMessage(String userId);
}
