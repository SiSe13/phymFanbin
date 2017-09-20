package com.phym.dao;

import java.util.List;

import com.phym.entity.OutDoorScreen;

public interface OutDoorScreenDao {
	//户外大屏检索
	List<OutDoorScreen> findOutdoor(OutDoorScreen outDoorScreen);
}
