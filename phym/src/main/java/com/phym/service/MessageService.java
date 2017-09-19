package com.phym.service;

import com.phym.entity.Message;
import com.phym.exception.MessageExitException;

public interface MessageService {
	
	//≤È—Ø–≈œ¢
	Message findMessage(String userId)throws MessageExitException;
}
