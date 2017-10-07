package com.phym.util;

import java.io.Serializable;

public class JsonResult<T> implements Serializable{

	/**
	 * 结果对象
	 * {"status":0,"msg":"成功","data":xxx}
	 */
	private static final long serialVersionUID = -5584221832638794420L;
	
	private int status;//0表示成功，其他表示失败
	private String msg;//消息
	private T data;//返回的数据
	
	public static final int SUCCESS=0; //成功
	public static final int ERROR=1;   //失败
	
	
	
	public JsonResult() {
		super();
		status = SUCCESS;
		msg = "";
	}
	public JsonResult(T data) {
		super();
		status = SUCCESS;
		this.data = data;
	}
	
	public JsonResult(Throwable e) {
		
		status = ERROR;
		msg = e.getMessage();
	}
	
	public JsonResult(int status,Throwable e) {
		
		this.status = status;
		msg = e.getMessage();
	}
	
	public JsonResult(int status,T data) {
		
		this.status = status;
		this.data = data;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "JsonResult [status=" + status + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
	
}
