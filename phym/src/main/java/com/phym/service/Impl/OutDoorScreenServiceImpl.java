package com.phym.service.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.phym.dao.OutDoorScreenDao;
import com.phym.entity.OutDoorScreen;
import com.phym.exception.OutDoorScreenExitException;
import com.phym.service.OutDoorScreenService;

@Service("outDoorScreenService")
public class OutDoorScreenServiceImpl implements OutDoorScreenService {
	@Autowired
	private OutDoorScreenDao outDoorScreenDao;
	/**
	 * 检索户外大屏
	 */
	public List<OutDoorScreen> findOutdoor(OutDoorScreen outDoorScreen)throws OutDoorScreenExitException {
		
		List<OutDoorScreen> list=outDoorScreenDao.findOutdoor(outDoorScreen);
		if(list==null){
			throw new OutDoorScreenExitException("无内容");
		}
		return list;
	}
	

	//订单查询
	public List<OutDoorScreen> listcontent(String outdoorId) throws OutDoorScreenExitException {
		if(outdoorId==null){
			throw new OutDoorScreenExitException("您还没有订单");
		}
		List<String> lisr =new ArrayList<String>();
		String[] arr= outdoorId.split(","); 
		for(int i=0;i<arr.length;i++){
			lisr.add(arr[i]);
		}
		List<OutDoorScreen> list= outDoorScreenDao.findOutdoorcontent(lisr);
		return list;
	}
}
