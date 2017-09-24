package com.phym.exception;

public class OrderFormException extends RuntimeException {

	private static final long serialVersionUID = -3219066540174276488L;

	public OrderFormException() {
	}

	public OrderFormException(String message) {
		super(message);
	}

	public OrderFormException(Throwable cause) {
		super(cause);
	}

	public OrderFormException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderFormException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
