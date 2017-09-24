package com.phym.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户完善信息表
 * @author S_s
 *
 */
public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = -2992717532172736317L;
	
	private	String id;				//完善表Id
	private	String userId;			//用户Id
	private	String name;			//真实姓名
	private	String tel;				//座机
	private	String addr;			//地址
	private	String email;			//邮箱
	private	String company;			//公司名称
	private	Timestamp updateTime;	//更新时间
	private	String headimg;			//头像
	private	String agencyName;		//代理商名称
	private	int agencyNumber;		//代理商编号
	
	public UserInfo() {
		super();
		
	}

	public UserInfo(String id, String userId, String name, String tel, String addr, String email, String company,
			Timestamp updateTime, String headimg, String agencyName, int agencyNumber) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
		this.company = company;
		this.updateTime = updateTime;
		this.headimg = headimg;
		this.agencyName = agencyName;
		this.agencyNumber = agencyNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public int getAgencyNumber() {
		return agencyNumber;
	}

	public void setAgencyNumber(int agencyNumber) {
		this.agencyNumber = agencyNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((agencyName == null) ? 0 : agencyName.hashCode());
		result = prime * result + agencyNumber;
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((headimg == null) ? 0 : headimg.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		result = prime * result + ((updateTime == null) ? 0 : updateTime.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (agencyName == null) {
			if (other.agencyName != null)
				return false;
		} else if (!agencyName.equals(other.agencyName))
			return false;
		if (agencyNumber != other.agencyNumber)
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (headimg == null) {
			if (other.headimg != null)
				return false;
		} else if (!headimg.equals(other.headimg))
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
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		if (updateTime == null) {
			if (other.updateTime != null)
				return false;
		} else if (!updateTime.equals(other.updateTime))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", userId=" + userId + ", name=" + name + ", tel=" + tel + ", addr=" + addr
				+ ", email=" + email + ", company=" + company + ", updateTime=" + updateTime + ", headimg=" + headimg
				+ ", agencyName=" + agencyName + ", agencyNumber=" + agencyNumber + "]";
	}
	
	
	

}
