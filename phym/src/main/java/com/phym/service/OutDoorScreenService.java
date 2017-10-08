package com.phym.service;

import java.util.List;

import com.phym.entity.OrderMedia;
import com.phym.entity.OutDoorScreen;
import com.phym.exception.OutDoorScreenException;

public interface OutDoorScreenService {
	
	//上传媒体资源
	public Boolean uploadResource(OutDoorScreen outDoor)throws OutDoorScreenException;
	//媒体主点击户外大屏显示媒体资源
	public List<OutDoorScreen> loadOutDoor(String outdoorProvince,String outdoorCity,String outdoorCountry,String outdoorScreenType,String outdoorMediasourceType,String userId)throws OutDoorScreenException;
	//删除媒体资源
	public Boolean deleteMediaResource(String outdoorId)throws OutDoorScreenException;
	//通过id查询媒体资源
	public OutDoorScreen findOutDoorScreenById(String outDoorId)throws OutDoorScreenException;
	//修改媒体资源
	public Boolean modifyOutDoor(OutDoorScreen outDoor)throws OutDoorScreenException;
	//点击户外大屏加载审核通过的所有资源
	public List<OutDoorScreen> findOutDoor(String outdoorProvince,String outdoorCity,String outdoorCountry,String outdoorScreenType,String outdoorMediasourceType,int pager) throws OutDoorScreenException;
	//跳转订单页面加载
	public List<OutDoorScreen> findOutDoorContent(String outDoorId)throws OutDoorScreenException;
	////查询大屏数据总数
	public int sumOutDoor(OutDoorScreen outDoor)throws OutDoorScreenException;
	//审核
	public Boolean auditOutDoor(OutDoorScreen outDoor)throws OutDoorScreenException;
	//开始订单筛选
	public List<OutDoorScreen> filtrateScreen(String outdoorProvince,String outdoorCity,String outdoorCountry, String checkshipin,
				String shichang,String outdoorScreenType,String outdoorMediasourceType,int pager)throws OutDoorScreenException;
	
	//通过媒体主id查询订单
	public List<OrderMedia> findOrderFormByUserId(String userId);
}
