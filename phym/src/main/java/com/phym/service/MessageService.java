package com.phym.service;

import com.phym.entity.Message;
import com.phym.exception.MessageExitException;

public interface MessageService {
	
	//��ѯ��Ϣ
	Message findMessage(String userId)throws MessageExitException;
}
