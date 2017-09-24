package com.phym.dao;

import java.util.List;
import com.phym.entity.OutDoorScreen;

public interface OutDoorScreenDao {
	//户外大屏检索
	List<OutDoorScreen> findOutdoor(OutDoorScreen outDoorScreen);
	
	//NoteDao 接口
	int countOutdoor(String outdoorId);
	
	//订单查询
	List<OutDoorScreen>	findOutdoorcontent(List<String> list);

	

	
}
