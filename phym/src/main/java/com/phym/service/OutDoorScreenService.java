package com.phym.service;

import java.util.List;
import com.phym.entity.OutDoorScreen;
import com.phym.exception.OutDoorScreenExitException;

public interface OutDoorScreenService {
	//查所有的大屏信息
	List<OutDoorScreen> findOutdoor(OutDoorScreen outDoorScreen) throws OutDoorScreenExitException;
	
	
	
	//订单查询
	List<OutDoorScreen> listcontent(String outdoorId) throws OutDoorScreenExitException;
	
	
}
