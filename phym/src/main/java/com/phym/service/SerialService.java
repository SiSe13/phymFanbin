package com.phym.service;

import java.util.List;

import com.phym.entity.Serial;
import com.phym.exception.SerialException;

public interface SerialService {
	//查询所有代理商编号
	public List<Serial> findAllSerial() throws SerialException;
	//更改用过的编号状态
	public Boolean updateSerialStatus(String number) throws SerialException;
}
