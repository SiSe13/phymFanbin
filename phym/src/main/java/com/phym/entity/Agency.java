package com.phym.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Agency implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -305650413958407271L;
	private String id; // 代理商id
	private String name;//代理商用户名
	private String password;// 密码
	private int level;// 代理商等级
	private String code;//代理商编号
	private int balance;// 代理商余额  不可提现
	private int deposit;// 代理商余额	可提现
	private String phone;// 电话
	private String province;// 区域-省
	private String city;//区域-市
	private String area;//区域-区/县
	private String manager;//渠道经理
	private Timestamp createTime;//创建时间
	private int status;//状态 1广告代理商  2媒体代理商
	private String demo2;//
	private String demo3;//
	private String demo4;//
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getDemo2() {
		return demo2;
	}
	public void setDemo2(String demo2) {
		this.demo2 = demo2;
	}
	public String getDemo3() {
		return demo3;
	}
	public void setDemo3(String demo3) {
		this.demo3 = demo3;
	}
	public String getDemo4() {
		return demo4;
	}
	public void setDemo4(String demo4) {
		this.demo4 = demo4;
	}
	public Agency() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Agency(String id, String name, String password, int level, String code, int balance, int deposit,
			String phone, String province, String city, String area, String manager, Timestamp createTime, int status,
			String demo2, String demo3, String demo4) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.level = level;
		this.code = code;
		this.balance = balance;
		this.deposit = deposit;
		this.phone = phone;
		this.province = province;
		this.city = city;
		this.area = area;
		this.manager = manager;
		this.createTime = createTime;
		this.status = status;
		this.demo2 = demo2;
		this.demo3 = demo3;
		this.demo4 = demo4;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + balance;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((demo2 == null) ? 0 : demo2.hashCode());
		result = prime * result + ((demo3 == null) ? 0 : demo3.hashCode());
		result = prime * result + ((demo4 == null) ? 0 : demo4.hashCode());
		result = prime * result + deposit;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + level;
		result = prime * result + ((manager == null) ? 0 : manager.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		result = prime * result + status;
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
		Agency other = (Agency) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (balance != other.balance)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (demo2 == null) {
			if (other.demo2 != null)
				return false;
		} else if (!demo2.equals(other.demo2))
			return false;
		if (demo3 == null) {
			if (other.demo3 != null)
				return false;
		} else if (!demo3.equals(other.demo3))
			return false;
		if (demo4 == null) {
			if (other.demo4 != null)
				return false;
		} else if (!demo4.equals(other.demo4))
			return false;
		if (deposit != other.deposit)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (level != other.level)
			return false;
		if (manager == null) {
			if (other.manager != null)
				return false;
		} else if (!manager.equals(other.manager))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (province == null) {
			if (other.province != null)
				return false;
		} else if (!province.equals(other.province))
			return false;
		if (status != other.status)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Agency [id=" + id + ", name=" + name + ", password=" + password + ", level=" + level + ", code=" + code
				+ ", balance=" + balance + ", deposit=" + deposit + ", phone=" + phone + ", province=" + province
				+ ", city=" + city + ", area=" + area + ", manager=" + manager + ", createTime=" + createTime
				+ ", status=" + status + ", demo2=" + demo2 + ", demo3=" + demo3 + ", demo4=" + demo4 + "]";
	}
	
	

}
