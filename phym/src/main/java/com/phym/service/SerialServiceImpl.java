package com.phym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.SerialDao;
import com.phym.entity.Serial;
import com.phym.exception.SerialException;

@Service("serialService")
public class SerialServiceImpl implements SerialService {
	@Autowired
	private SerialDao dao;
	
	//查询所有代理商编号
	public List<Serial> findAllSerial() throws SerialException{
		List<Serial> list = dao.findAllSerial();
		if(list.isEmpty()) {
			throw new SerialException("暂无代理商编号");
		}
		
		return list;
	}
	
	//更改用过的编号状态
	public Boolean updateSerialStatus(String number) throws SerialException{
		if(number==null||number.isEmpty()||number.equals("")) {
			throw new SerialException("请输入编号");
		}
		int n = dao.updateSerialStatus(number);
		if(n!=1) {
			throw new SerialException("更新状态失败");
		}
		
		return true;
	}

}
