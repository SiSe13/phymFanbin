package com.phym.dao;

import java.util.List;

import com.phym.entity.ChannelManager;

public interface ChannelManagerDao {
	//添加区域经理
	public int insertManager(ChannelManager manager);
	//通过id查询区域经理
	public ChannelManager findManagerById(String id);
	//同过名字查询区域经理
	public ChannelManager findManagerByName(String name);
	//通过手机号查询区域经理
	public ChannelManager findManagerByPhone(String phone);
	//查询所有区域经理
	public List<ChannelManager> findAllManager();
	//通过id删除区域经理
	public int deleteManagerById(String id);
	//通过名字删除区域经理
	public int deleteManagerByName(String name);
	//通过电话删除区域经理
	public int deleteManagerByPhone(String name);
	
	
}
