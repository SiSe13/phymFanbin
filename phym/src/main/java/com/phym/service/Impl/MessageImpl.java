package com.phym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.MessageDao;
import com.phym.dao.UserDao;
import com.phym.entity.Message;
import com.phym.entity.User;
import com.phym.exception.MessageExitException;
import com.phym.service.MessageService;

@Service("messageService")
public class MessageImpl implements MessageService {
	@Autowired
	private UserDao userdao;
	
	@Autowired
	private MessageDao messageDao;
	
	public Message findMessage(String userId)throws MessageExitException {
		if(userId==null || userId.trim().isEmpty()){
			throw new MessageExitException("ID���ܿ�");
		}
		User user=userdao.findUserById(userId);
		
		if(user==null){
			throw new MessageExitException("ID������");
		}
		
		Message message=messageDao.findMessage(userId);
		if(message==null){
			throw new MessageExitException("����Ϣ");
		}
		return message;
	}

}
