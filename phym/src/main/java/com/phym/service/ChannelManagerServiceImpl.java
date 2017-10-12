package com.phym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.ChannelManagerDao;
import com.phym.entity.ChannelManager;
import com.phym.exception.ChannelManagerException;

@Service("channelManagerService")
public class ChannelManagerServiceImpl implements ChannelManagerService {
	@Autowired
	private ChannelManagerDao dao;
	
	//同过名字查询区域经理
	public ChannelManager findManagerByName(String name) {
		if(name ==null||name.isEmpty()||name.equals("")) {
			throw new ChannelManagerException("用户名不能为空");
		}
		ChannelManager man = dao.findManagerByName(name);
		if(man==null) {
			throw new ChannelManagerException("网络延迟");
		}
		return man;
	}

}
