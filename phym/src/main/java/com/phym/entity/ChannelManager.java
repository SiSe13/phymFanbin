package com.phym.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class ChannelManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6286171719284730686L;
	private String id;
	private String name;
	private String phone;
	private Timestamp createTime;
	private String demo1;
	private String demo2;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public String getDemo1() {
		return demo1;
	}
	public void setDemo1(String demo1) {
		this.demo1 = demo1;
	}
	public String getDemo2() {
		return demo2;
	}
	public void setDemo2(String demo2) {
		this.demo2 = demo2;
	}
	public ChannelManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChannelManager(String id, String name, String phone, Timestamp createTime, String demo1, String demo2) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.createTime = createTime;
		this.demo1 = demo1;
		this.demo2 = demo2;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((demo1 == null) ? 0 : demo1.hashCode());
		result = prime * result + ((demo2 == null) ? 0 : demo2.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		ChannelManager other = (ChannelManager) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (demo1 == null) {
			if (other.demo1 != null)
				return false;
		} else if (!demo1.equals(other.demo1))
			return false;
		if (demo2 == null) {
			if (other.demo2 != null)
				return false;
		} else if (!demo2.equals(other.demo2))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChannelManager [id=" + id + ", name=" + name + ", phone=" + phone + ", createTime=" + createTime
				+ ", demo1=" + demo1 + ", demo2=" + demo2 + "]";
	}
	
	
	
	
	
}
