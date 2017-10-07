package com.phym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.phym.entity.OutDoorScreen;


public interface OutDoorScreenDao {
	//添加媒体资源
	public int insertOutDoor(OutDoorScreen outDoor);
	//媒体主点击户外大屏显示媒体资源
	public List<OutDoorScreen> loadOutDoor(@Param("outdoorProvince") String outdoorProvince,@Param("outdoorCity") String outdoorCity,@Param("outdoorCountry") String outdoorCountry,@Param("outdoorScreenType") String outdoorScreenType,@Param("outdoorMediasourceType") String outdoorMediasourceType,@Param("outdoorUserName") String outdoorUserName);
	//通过资源id查找媒体资源
	public OutDoorScreen findOutDoorScreenById(String outDoorId);
	//修改媒体资源
	public int modifyOutDoor(OutDoorScreen outDoor);
	//删除媒体资源
	public int deleteOutDoor(String outdoorId);
	//点击户外大屏加载所有通过审核的资源
	public List<OutDoorScreen> findOutDoor(@Param("outdoorProvince") String outdoorProvince,@Param("outdoorCity") String outdoorCity,@Param("outdoorCountry") String outdoorCountry,@Param("outdoorScreenType") String outdoorScreenType,@Param("outdoorMediasourceType") String outdoorMediasourceType,@Param("pager")int pager);  
	//加载订单
	public List<OutDoorScreen> findOutDoorContent(List<String> list);
	//查询大屏数据总数
	public int sumOutDoor(OutDoorScreen outDoor);
	//审核
	public int auditOutDoor(OutDoorScreen outDoor);
	
	
	
}
