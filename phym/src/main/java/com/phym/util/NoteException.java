package com.phym.util;
/**
 * 自定义异常
 * @author shadowevels
 *
 */
public class NoteException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6362395789168167371L;

	public NoteException(String msg,Throwable t) {
		super(msg,t);
	}
	
	public NoteException(String msg) {
		super(msg);
	}
	
}
