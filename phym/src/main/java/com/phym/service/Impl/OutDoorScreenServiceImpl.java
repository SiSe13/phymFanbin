package com.phym.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phym.dao.OutDoorScreenDao;
import com.phym.entity.OutDoorScreen;
import com.phym.service.OutDoorScreenService;

@Service("outDoorScreenService")
public class OutDoorScreenServiceImpl implements OutDoorScreenService {
	@Autowired
	private OutDoorScreenDao outDoorScreenDao;
	/**
	 * 检索户外大屏
	 */
	public List<OutDoorScreen> findOutdoor(OutDoorScreen outDoorScreen) {
		List<OutDoorScreen> list=outDoorScreenDao.findOutdoor(outDoorScreen);
		return list;
	}

}
