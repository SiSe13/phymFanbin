package com.phym.dao;

import java.util.List;

import com.phym.entity.Serial;

public interface SerialDao {
	
	//查询所有代理商编号状态为0
	public List<Serial> findAllSerial();
	//更改用过的编号状态
	public int updateSerialStatus(String number);
}
