package com.phym.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 户外大屏表
 * @author S_s
 *
 */
public class OutDoorScreen implements Serializable {
	private static final long serialVersionUID = -4500740317575311427L;
	
	private String outdoorId;//  id
	private String outdoorName;// 媒体名称
	private String outdoorProvince;// 省
	private String outdoorCity;// 市
	private String outdoorCountry;// 区/县
	private String outdoorAddress;//资源地址
	private String outdoorMediasourceType;//媒体属性（合约/非合约）
	private String outdoorScreenType;//屏幕类型 （跨街，横屏，竖屏）
	private String outdoorScreenSize;//屏幕尺寸
	private String outdoorLength;//分辨率 长
	private String outdoorHeight;//分辨率 高
	private String outdoorPlayStartTime;//播放时间开始
	private String outdoorPlayEndTime;//播放时间结束
	private String outdoorUserName;//所有者 （媒体主名）
	private String outdoorUnitPrice; //单价
	private int outdoorStatus;//状态 （正常）
	private int outdoorCheckStatus;// 审核状态（审核中，通过，拒绝）
	private String outdoorPhotoPath;//照片
	private String outdoorSuperiority;//优势
	private String outdoorAptitude;//资质文件
	private Timestamp outdoorCreatedDate;//创建时间
	private String outdoorRemark;//备注
	private String outdoorFrequency;//频次
	private String outdoorPlaybackPeriod;//播放周期
	private Timestamp outdoorModifyDate; //更新时间
	private String auditName;//审核人
	private Timestamp auditDate;//审核时间
	private int remainTime;//剩余时间
	private String demo1;//备用
	private String demo2;
	public String getOutdoorId() {
		return outdoorId;
	}
	public void setOutdoorId(String outdoorId) {
		this.outdoorId = outdoorId;
	}
	public String getOutdoorName() {
		return outdoorName;
	}
	public void setOutdoorName(String outdoorName) {
		this.outdoorName = outdoorName;
	}
	public String getOutdoorProvince() {
		return outdoorProvince;
	}
	public void setOutdoorProvince(String outdoorProvince) {
		this.outdoorProvince = outdoorProvince;
	}
	public String getOutdoorCity() {
		return outdoorCity;
	}
	public void setOutdoorCity(String outdoorCity) {
		this.outdoorCity = outdoorCity;
	}
	public String getOutdoorCountry() {
		return outdoorCountry;
	}
	public void setOutdoorCountry(String outdoorCountry) {
		this.outdoorCountry = outdoorCountry;
	}
	public String getOutdoorAddress() {
		return outdoorAddress;
	}
	public void setOutdoorAddress(String outdoorAddress) {
		this.outdoorAddress = outdoorAddress;
	}
	public String getOutdoorMediasourceType() {
		return outdoorMediasourceType;
	}
	public void setOutdoorMediasourceType(String outdoorMediasourceType) {
		this.outdoorMediasourceType = outdoorMediasourceType;
	}
	public String getOutdoorScreenType() {
		return outdoorScreenType;
	}
	public void setOutdoorScreenType(String outdoorScreenType) {
		this.outdoorScreenType = outdoorScreenType;
	}
	public String getOutdoorScreenSize() {
		return outdoorScreenSize;
	}
	public void setOutdoorScreenSize(String outdoorScreenSize) {
		this.outdoorScreenSize = outdoorScreenSize;
	}
	public String getOutdoorLength() {
		return outdoorLength;
	}
	public void setOutdoorLength(String outdoorLength) {
		this.outdoorLength = outdoorLength;
	}
	public String getOutdoorHeight() {
		return outdoorHeight;
	}
	public void setOutdoorHeight(String outdoorHeight) {
		this.outdoorHeight = outdoorHeight;
	}
	public String getOutdoorPlayStartTime() {
		return outdoorPlayStartTime;
	}
	public void setOutdoorPlayStartTime(String outdoorPlayStartTime) {
		this.outdoorPlayStartTime = outdoorPlayStartTime;
	}
	public String getOutdoorPlayEndTime() {
		return outdoorPlayEndTime;
	}
	public void setOutdoorPlayEndTime(String outdoorPlayEndTime) {
		this.outdoorPlayEndTime = outdoorPlayEndTime;
	}
	public String getOutdoorUserName() {
		return outdoorUserName;
	}
	public void setOutdoorUserName(String outdoorUserName) {
		this.outdoorUserName = outdoorUserName;
	}
	public String getOutdoorUnitPrice() {
		return outdoorUnitPrice;
	}
	public void setOutdoorUnitPrice(String outdoorUnitPrice) {
		this.outdoorUnitPrice = outdoorUnitPrice;
	}
	public int getOutdoorStatus() {
		return outdoorStatus;
	}
	public void setOutdoorStatus(int outdoorStatus) {
		this.outdoorStatus = outdoorStatus;
	}
	public int getOutdoorCheckStatus() {
		return outdoorCheckStatus;
	}
	public void setOutdoorCheckStatus(int outdoorCheckStatus) {
		this.outdoorCheckStatus = outdoorCheckStatus;
	}
	public String getOutdoorPhotoPath() {
		return outdoorPhotoPath;
	}
	public void setOutdoorPhotoPath(String outdoorPhotoPath) {
		this.outdoorPhotoPath = outdoorPhotoPath;
	}
	public String getOutdoorSuperiority() {
		return outdoorSuperiority;
	}
	public void setOutdoorSuperiority(String outdoorSuperiority) {
		this.outdoorSuperiority = outdoorSuperiority;
	}
	public String getOutdoorAptitude() {
		return outdoorAptitude;
	}
	public void setOutdoorAptitude(String outdoorAptitude) {
		this.outdoorAptitude = outdoorAptitude;
	}
	public Timestamp getOutdoorCreatedDate() {
		return outdoorCreatedDate;
	}
	public void setOutdoorCreatedDate(Timestamp outdoorCreatedDate) {
		this.outdoorCreatedDate = outdoorCreatedDate;
	}
	public String getOutdoorRemark() {
		return outdoorRemark;
	}
	public void setOutdoorRemark(String outdoorRemark) {
		this.outdoorRemark = outdoorRemark;
	}
	public String getOutdoorFrequency() {
		return outdoorFrequency;
	}
	public void setOutdoorFrequency(String outdoorFrequency) {
		this.outdoorFrequency = outdoorFrequency;
	}
	public String getOutdoorPlaybackPeriod() {
		return outdoorPlaybackPeriod;
	}
	public void setOutdoorPlaybackPeriod(String outdoorPlaybackPeriod) {
		this.outdoorPlaybackPeriod = outdoorPlaybackPeriod;
	}
	public Timestamp getOutdoorModifyDate() {
		return outdoorModifyDate;
	}
	public void setOutdoorModifyDate(Timestamp outdoorModifyDate) {
		this.outdoorModifyDate = outdoorModifyDate;
	}
	public String getAuditName() {
		return auditName;
	}
	public void setAuditName(String auditName) {
		this.auditName = auditName;
	}
	public Timestamp getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}
	public int getRemainTime() {
		return remainTime;
	}
	public void setRemainTime(int remainTime) {
		this.remainTime = remainTime;
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
	public OutDoorScreen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OutDoorScreen(String outdoorId, String outdoorName, String outdoorProvince, String outdoorCity,
			String outdoorCountry, String outdoorAddress, String outdoorMediasourceType, String outdoorScreenType,
			String outdoorScreenSize, String outdoorLength, String outdoorHeight, String outdoorPlayStartTime,
			String outdoorPlayEndTime, String outdoorUserName, String outdoorUnitPrice, int outdoorStatus,
			int outdoorCheckStatus, String outdoorPhotoPath, String outdoorSuperiority, String outdoorAptitude,
			Timestamp outdoorCreatedDate, String outdoorRemark, String outdoorFrequency, String outdoorPlaybackPeriod,
			Timestamp outdoorModifyDate, String auditName, Timestamp auditDate, int remainTime, String demo1,
			String demo2) {
		super();
		this.outdoorId = outdoorId;
		this.outdoorName = outdoorName;
		this.outdoorProvince = outdoorProvince;
		this.outdoorCity = outdoorCity;
		this.outdoorCountry = outdoorCountry;
		this.outdoorAddress = outdoorAddress;
		this.outdoorMediasourceType = outdoorMediasourceType;
		this.outdoorScreenType = outdoorScreenType;
		this.outdoorScreenSize = outdoorScreenSize;
		this.outdoorLength = outdoorLength;
		this.outdoorHeight = outdoorHeight;
		this.outdoorPlayStartTime = outdoorPlayStartTime;
		this.outdoorPlayEndTime = outdoorPlayEndTime;
		this.outdoorUserName = outdoorUserName;
		this.outdoorUnitPrice = outdoorUnitPrice;
		this.outdoorStatus = outdoorStatus;
		this.outdoorCheckStatus = outdoorCheckStatus;
		this.outdoorPhotoPath = outdoorPhotoPath;
		this.outdoorSuperiority = outdoorSuperiority;
		this.outdoorAptitude = outdoorAptitude;
		this.outdoorCreatedDate = outdoorCreatedDate;
		this.outdoorRemark = outdoorRemark;
		this.outdoorFrequency = outdoorFrequency;
		this.outdoorPlaybackPeriod = outdoorPlaybackPeriod;
		this.outdoorModifyDate = outdoorModifyDate;
		this.auditName = auditName;
		this.auditDate = auditDate;
		this.remainTime = remainTime;
		this.demo1 = demo1;
		this.demo2 = demo2;
	}
	@Override
	public String toString() {
		return "OutDoorScreen [outdoorId=" + outdoorId + ", outdoorName=" + outdoorName + ", outdoorProvince="
				+ outdoorProvince + ", outdoorCity=" + outdoorCity + ", outdoorCountry=" + outdoorCountry
				+ ", outdoorAddress=" + outdoorAddress + ", outdoorMediasourceType=" + outdoorMediasourceType
				+ ", outdoorScreenType=" + outdoorScreenType + ", outdoorScreenSize=" + outdoorScreenSize
				+ ", outdoorLength=" + outdoorLength + ", outdoorHeight=" + outdoorHeight + ", outdoorPlayStartTime="
				+ outdoorPlayStartTime + ", outdoorPlayEndTime=" + outdoorPlayEndTime + ", outdoorUserName="
				+ outdoorUserName + ", outdoorUnitPrice=" + outdoorUnitPrice + ", outdoorStatus=" + outdoorStatus
				+ ", outdoorCheckStatus=" + outdoorCheckStatus + ", outdoorPhotoPath=" + outdoorPhotoPath
				+ ", outdoorSuperiority=" + outdoorSuperiority + ", outdoorAptitude=" + outdoorAptitude
				+ ", outdoorCreatedDate=" + outdoorCreatedDate + ", outdoorRemark=" + outdoorRemark
				+ ", outdoorFrequency=" + outdoorFrequency + ", outdoorPlaybackPeriod=" + outdoorPlaybackPeriod
				+ ", outdoorModifyDate=" + outdoorModifyDate + ", auditName=" + auditName + ", auditDate=" + auditDate
				+ ", remainTime=" + remainTime + ", demo1=" + demo1 + ", demo2=" + demo2 + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditDate == null) ? 0 : auditDate.hashCode());
		result = prime * result + ((auditName == null) ? 0 : auditName.hashCode());
		result = prime * result + ((demo1 == null) ? 0 : demo1.hashCode());
		result = prime * result + ((demo2 == null) ? 0 : demo2.hashCode());
		result = prime * result + ((outdoorAddress == null) ? 0 : outdoorAddress.hashCode());
		result = prime * result + ((outdoorAptitude == null) ? 0 : outdoorAptitude.hashCode());
		result = prime * result + outdoorCheckStatus;
		result = prime * result + ((outdoorCity == null) ? 0 : outdoorCity.hashCode());
		result = prime * result + ((outdoorCountry == null) ? 0 : outdoorCountry.hashCode());
		result = prime * result + ((outdoorCreatedDate == null) ? 0 : outdoorCreatedDate.hashCode());
		result = prime * result + ((outdoorFrequency == null) ? 0 : outdoorFrequency.hashCode());
		result = prime * result + ((outdoorHeight == null) ? 0 : outdoorHeight.hashCode());
		result = prime * result + ((outdoorId == null) ? 0 : outdoorId.hashCode());
		result = prime * result + ((outdoorLength == null) ? 0 : outdoorLength.hashCode());
		result = prime * result + ((outdoorMediasourceType == null) ? 0 : outdoorMediasourceType.hashCode());
		result = prime * result + ((outdoorModifyDate == null) ? 0 : outdoorModifyDate.hashCode());
		result = prime * result + ((outdoorName == null) ? 0 : outdoorName.hashCode());
		result = prime * result + ((outdoorPhotoPath == null) ? 0 : outdoorPhotoPath.hashCode());
		result = prime * result + ((outdoorPlayEndTime == null) ? 0 : outdoorPlayEndTime.hashCode());
		result = prime * result + ((outdoorPlayStartTime == null) ? 0 : outdoorPlayStartTime.hashCode());
		result = prime * result + ((outdoorPlaybackPeriod == null) ? 0 : outdoorPlaybackPeriod.hashCode());
		result = prime * result + ((outdoorProvince == null) ? 0 : outdoorProvince.hashCode());
		result = prime * result + ((outdoorRemark == null) ? 0 : outdoorRemark.hashCode());
		result = prime * result + ((outdoorScreenSize == null) ? 0 : outdoorScreenSize.hashCode());
		result = prime * result + ((outdoorScreenType == null) ? 0 : outdoorScreenType.hashCode());
		result = prime * result + outdoorStatus;
		result = prime * result + ((outdoorSuperiority == null) ? 0 : outdoorSuperiority.hashCode());
		result = prime * result + ((outdoorUnitPrice == null) ? 0 : outdoorUnitPrice.hashCode());
		result = prime * result + ((outdoorUserName == null) ? 0 : outdoorUserName.hashCode());
		result = prime * result + remainTime;
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
		OutDoorScreen other = (OutDoorScreen) obj;
		if (auditDate == null) {
			if (other.auditDate != null)
				return false;
		} else if (!auditDate.equals(other.auditDate))
			return false;
		if (auditName == null) {
			if (other.auditName != null)
				return false;
		} else if (!auditName.equals(other.auditName))
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
		if (outdoorAddress == null) {
			if (other.outdoorAddress != null)
				return false;
		} else if (!outdoorAddress.equals(other.outdoorAddress))
			return false;
		if (outdoorAptitude == null) {
			if (other.outdoorAptitude != null)
				return false;
		} else if (!outdoorAptitude.equals(other.outdoorAptitude))
			return false;
		if (outdoorCheckStatus != other.outdoorCheckStatus)
			return false;
		if (outdoorCity == null) {
			if (other.outdoorCity != null)
				return false;
		} else if (!outdoorCity.equals(other.outdoorCity))
			return false;
		if (outdoorCountry == null) {
			if (other.outdoorCountry != null)
				return false;
		} else if (!outdoorCountry.equals(other.outdoorCountry))
			return false;
		if (outdoorCreatedDate == null) {
			if (other.outdoorCreatedDate != null)
				return false;
		} else if (!outdoorCreatedDate.equals(other.outdoorCreatedDate))
			return false;
		if (outdoorFrequency == null) {
			if (other.outdoorFrequency != null)
				return false;
		} else if (!outdoorFrequency.equals(other.outdoorFrequency))
			return false;
		if (outdoorHeight == null) {
			if (other.outdoorHeight != null)
				return false;
		} else if (!outdoorHeight.equals(other.outdoorHeight))
			return false;
		if (outdoorId == null) {
			if (other.outdoorId != null)
				return false;
		} else if (!outdoorId.equals(other.outdoorId))
			return false;
		if (outdoorLength == null) {
			if (other.outdoorLength != null)
				return false;
		} else if (!outdoorLength.equals(other.outdoorLength))
			return false;
		if (outdoorMediasourceType == null) {
			if (other.outdoorMediasourceType != null)
				return false;
		} else if (!outdoorMediasourceType.equals(other.outdoorMediasourceType))
			return false;
		if (outdoorModifyDate == null) {
			if (other.outdoorModifyDate != null)
				return false;
		} else if (!outdoorModifyDate.equals(other.outdoorModifyDate))
			return false;
		if (outdoorName == null) {
			if (other.outdoorName != null)
				return false;
		} else if (!outdoorName.equals(other.outdoorName))
			return false;
		if (outdoorPhotoPath == null) {
			if (other.outdoorPhotoPath != null)
				return false;
		} else if (!outdoorPhotoPath.equals(other.outdoorPhotoPath))
			return false;
		if (outdoorPlayEndTime == null) {
			if (other.outdoorPlayEndTime != null)
				return false;
		} else if (!outdoorPlayEndTime.equals(other.outdoorPlayEndTime))
			return false;
		if (outdoorPlayStartTime == null) {
			if (other.outdoorPlayStartTime != null)
				return false;
		} else if (!outdoorPlayStartTime.equals(other.outdoorPlayStartTime))
			return false;
		if (outdoorPlaybackPeriod == null) {
			if (other.outdoorPlaybackPeriod != null)
				return false;
		} else if (!outdoorPlaybackPeriod.equals(other.outdoorPlaybackPeriod))
			return false;
		if (outdoorProvince == null) {
			if (other.outdoorProvince != null)
				return false;
		} else if (!outdoorProvince.equals(other.outdoorProvince))
			return false;
		if (outdoorRemark == null) {
			if (other.outdoorRemark != null)
				return false;
		} else if (!outdoorRemark.equals(other.outdoorRemark))
			return false;
		if (outdoorScreenSize == null) {
			if (other.outdoorScreenSize != null)
				return false;
		} else if (!outdoorScreenSize.equals(other.outdoorScreenSize))
			return false;
		if (outdoorScreenType == null) {
			if (other.outdoorScreenType != null)
				return false;
		} else if (!outdoorScreenType.equals(other.outdoorScreenType))
			return false;
		if (outdoorStatus != other.outdoorStatus)
			return false;
		if (outdoorSuperiority == null) {
			if (other.outdoorSuperiority != null)
				return false;
		} else if (!outdoorSuperiority.equals(other.outdoorSuperiority))
			return false;
		if (outdoorUnitPrice == null) {
			if (other.outdoorUnitPrice != null)
				return false;
		} else if (!outdoorUnitPrice.equals(other.outdoorUnitPrice))
			return false;
		if (outdoorUserName == null) {
			if (other.outdoorUserName != null)
				return false;
		} else if (!outdoorUserName.equals(other.outdoorUserName))
			return false;
		if (remainTime != other.remainTime)
			return false;
		return true;
	}
	
	
}