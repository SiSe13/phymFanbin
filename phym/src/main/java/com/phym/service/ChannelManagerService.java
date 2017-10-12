package com.phym.service;

import com.phym.entity.ChannelManager;

public interface ChannelManagerService {
	
	//添加区域经理
	//public Boolean insertManager(ChannelManager manager);
	//通过id查询区域经理
	//public ChannelManager findManagerById(String id);
	//同过名字查询区域经理
	public ChannelManager findManagerByName(String name);
}
