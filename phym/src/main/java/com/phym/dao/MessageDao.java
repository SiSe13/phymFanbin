package com.phym.dao;

import com.phym.entity.Message;

public interface MessageDao {
	
	//��ѯ������Ϣ
	Message findMessage(String userId);
}
