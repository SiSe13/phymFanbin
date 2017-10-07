package com.phym.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderMedia implements Serializable{

	private static final long serialVersionUID = 6314473357407218812L;
	
	private String id;     //id
	private String number;		//订单编号	
	private String mediaId;		//屏幕资源id
	private int status;			//大屏状态
	private	String mediaCost;   //单个大屏的费用
	private	String videoName;	//广告名称
	private Timestamp createTime; //订单创建时间
	private int orderStatus; //订单状态
	private String advertName; //广告主名称
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMediaId() {
		return mediaId;
	}
	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMediaCost() {
		return mediaCost;
	}
	public void setMediaCost(String mediaCost) {
		this.mediaCost = mediaCost;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getAdvertName() {
		return advertName;
	}
	public void setAdvertName(String advertName) {
		this.advertName = advertName;
	}
	public OrderMedia() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderMedia(String id, String number, String mediaId, int status, String mediaCost, String videoName,
			Timestamp createTime, int orderStatus, String advertName) {
		super();
		this.id = id;
		this.number = number;
		this.mediaId = mediaId;
		this.status = status;
		this.mediaCost = mediaCost;
		this.videoName = videoName;
		this.createTime = createTime;
		this.orderStatus = orderStatus;
		this.advertName = advertName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advertName == null) ? 0 : advertName.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mediaCost == null) ? 0 : mediaCost.hashCode());
		result = prime * result + ((mediaId == null) ? 0 : mediaId.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + orderStatus;
		result = prime * result + status;
		result = prime * result + ((videoName == null) ? 0 : videoName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderMedia other = (OrderMedia) obj;
		if (advertName == null) {
			if (other.advertName != null)
				return false;
		} else if (!advertName.equals(other.advertName))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mediaCost == null) {
			if (other.mediaCost != null)
				return false;
		} else if (!mediaCost.equals(other.mediaCost))
			return false;
		if (mediaId == null) {
			if (other.mediaId != null)
				return false;
		} else if (!mediaId.equals(other.mediaId))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (orderStatus != other.orderStatus)
			return false;
		if (status != other.status)
			return false;
		if (videoName == null) {
			if (other.videoName != null)
				return false;
		} else if (!videoName.equals(other.videoName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderMedia [id=" + id + ", number=" + number + ", mediaId=" + mediaId + ", status=" + status
				+ ", mediaCost=" + mediaCost + ", videoName=" + videoName + ", createTime=" + createTime
				+ ", orderStatus=" + orderStatus + ", advertName=" + advertName + "]";
	}
	
	
}
