package com.phym.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class OrderForm implements Serializable {

	private static final long serialVersionUID = -314209549742452513L;
	private String id;// 
	private String number;//订单标号
	private String videoName;//视频名称
	private String startTime;//开始时间
	private String endTime;//结束时间
	private String videoType;//视频 url
	private String duration;//播放时长
	private String userId;//用户id
	private int orderType; //订单状态  0审核中 1 审核通过 2未通过 3支付4未支付
	private int status;//播放状态 --0未播放 --1播放中
	private Timestamp createTime; //创建时间
	private String htRemark;//后台备注
	private String qtRemark;//前台备注
	private Timestamp auditTime;//审核时间
	private String auditName;//审核人
	private String cost;//费用
	
	public OrderForm() {
		super();
		
	}
	
	public OrderForm(String id, String number, String videoName, String startTime, String endTime, String videoType,
			String duration, String userId, int orderType, int status, Timestamp createTime, String htRemark,
			String qtRemark, Timestamp auditTime, String auditName, String cost) {
		super();
		this.id = id;
		this.number = number;
		this.videoName = videoName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.videoType = videoType;
		this.duration = duration;
		this.userId = userId;
		this.orderType = orderType;
		this.status = status;
		this.createTime = createTime;
		this.htRemark = htRemark;
		this.qtRemark = qtRemark;
		this.auditTime = auditTime;
		this.auditName = auditName;
		this.cost = cost;
	}
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
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getOrderType() {
		return orderType;
	}
	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getHtRemark() {
		return htRemark;
	}
	public void setHtRemark(String htRemark) {
		this.htRemark = htRemark;
	}
	public String getQtRemark() {
		return qtRemark;
	}
	public void setQtRemark(String qtRemark) {
		this.qtRemark = qtRemark;
	}
	public Timestamp getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Timestamp auditTime) {
		this.auditTime = auditTime;
	}
	public String getAuditName() {
		return auditName;
	}
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditName == null) ? 0 : auditName.hashCode());
		result = prime * result + ((auditTime == null) ? 0 : auditTime.hashCode());
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((htRemark == null) ? 0 : htRemark.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + orderType;
		result = prime * result + ((qtRemark == null) ? 0 : qtRemark.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		result = prime * result + status;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((videoName == null) ? 0 : videoName.hashCode());
		result = prime * result + ((videoType == null) ? 0 : videoType.hashCode());
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
		OrderForm other = (OrderForm) obj;
		if (auditName == null) {
			if (other.auditName != null)
				return false;
		} else if (!auditName.equals(other.auditName))
			return false;
		if (auditTime == null) {
			if (other.auditTime != null)
				return false;
		} else if (!auditTime.equals(other.auditTime))
			return false;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (duration == null) {
			if (other.duration != null)
				return false;
		} else if (!duration.equals(other.duration))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (htRemark == null) {
			if (other.htRemark != null)
				return false;
		} else if (!htRemark.equals(other.htRemark))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (orderType != other.orderType)
			return false;
		if (qtRemark == null) {
			if (other.qtRemark != null)
				return false;
		} else if (!qtRemark.equals(other.qtRemark))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (status != other.status)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (videoName == null) {
			if (other.videoName != null)
				return false;
		} else if (!videoName.equals(other.videoName))
			return false;
		if (videoType == null) {
			if (other.videoType != null)
				return false;
		} else if (!videoType.equals(other.videoType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderForm [id=" + id + ", number=" + number + ", videoName=" + videoName + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", videoType=" + videoType + ", duration=" + duration + ", userId=" + userId
				+ ", orderType=" + orderType + ", status=" + status + ", createTime=" + createTime + ", htRemark="
				+ htRemark + ", qtRemark=" + qtRemark + ", auditTime=" + auditTime + ", auditName=" + auditName
				+ ", cost=" + cost + "]";
	}
	
	
}
