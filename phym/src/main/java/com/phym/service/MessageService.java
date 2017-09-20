package com.phym.service;

import com.phym.entity.Message;
import com.phym.exception.MessageExitException;

public interface MessageService {
	
	//查询信息
	Message findMessage(String userId)throws MessageExitException;
}
