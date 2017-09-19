package com.phym.exception;

public class MessageExitException extends RuntimeException {

	private static final long serialVersionUID = 8890131889523933690L;

	public MessageExitException() {
	}

	public MessageExitException(String message) {
		super(message);
	}

	public MessageExitException(Throwable cause) {
		super(cause);
	}

	public MessageExitException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessageExitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
