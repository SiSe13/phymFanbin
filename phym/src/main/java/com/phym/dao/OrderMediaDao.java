package com.phym.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.phym.entity.OrderMedia;

public interface OrderMediaDao {
	
	//插入媒体订单表
	int insertOrderMedia(OrderMedia orderMedia);
	//更改状态
	public int updateMediaStatus(@Param("number") String unmber,@Param("orderStatus") int orderStatus);
	//后台删除订单关联大屏
	public int deleteOrderMedia(String number);
	
	//查询所有的
	public List<OrderMedia> findAllOrderMedia();
	
	//通过订单编号查询
	public List<OrderMedia> findOrderMediaByNumber(String number);
}
