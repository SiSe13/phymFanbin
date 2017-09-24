package com.phym.entity;

import java.io.Serializable;

/**
 * 订单媒体资源表 
 * @author S_s
 *
 */
public class OrderMedia implements Serializable {

	private static final long serialVersionUID = 6314473357407218812L;

	private String id; 
	private String number;
	private String mediaId;
	private int status;
	
	public OrderMedia() {
	}

	public OrderMedia(String id, String number, String mediaId, int status) {
		super();
		this.id = id;
		this.number = number;
		this.mediaId = mediaId;
		this.status = status;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mediaId == null) ? 0 : mediaId.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		OrderMedia other = (OrderMedia) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderMedia [id=" + id + ", number=" + number + ", mediaId=" + mediaId + ", status=" + status + "]";
	}
	
	
}
