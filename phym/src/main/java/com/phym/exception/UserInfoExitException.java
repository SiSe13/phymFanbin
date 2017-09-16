package com.phym.exception;

public class UserInfoExitException extends RuntimeException {

	private static final long serialVersionUID = -2900119469653484539L;

	public UserInfoExitException() {
	}

	public UserInfoExitException(String message) {
		super(message);
	}

	public UserInfoExitException(Throwable cause) {
		super(cause);
	}

	public UserInfoExitException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserInfoExitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
