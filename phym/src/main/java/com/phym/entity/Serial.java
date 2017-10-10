package com.phym.entity;

import java.io.Serializable;

public class Serial implements Serializable{
	private static final long serialVersionUID = -2272262151445893914L;
	private String id;
	private String number;
	private int states;
	
	public Serial() {
		
	}

	public Serial(String id, String number, int states) {
		super();
		this.id = id;
		this.number = number;
		this.states = states;
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

	public int getStates() {
		return states;
	}

	public void setStates(int states) {
		this.states = states;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + states;
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
		Serial other = (Serial) obj;
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
		if (states != other.states)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Serial [id=" + id + ", number=" + number + ", states=" + states + "]";
	}

	
}
