package com.phym.exception;

public class OrderMediaException extends RuntimeException {
	private static final long serialVersionUID = -153804553286926494L;

	public OrderMediaException() {
	}

	public OrderMediaException(String message) {
		super(message);
	}

	public OrderMediaException(Throwable cause) {
		super(cause);
	}

	public OrderMediaException(String message, Throwable cause) {
		super(message, cause);
	}

	public OrderMediaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
