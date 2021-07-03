package com.umishra.TaskManager.Exception;

public class QuoteNotfoundException extends RuntimeException {

	public QuoteNotfoundException() {
	}

	public QuoteNotfoundException(String message) {
		super(message);
	}

	public QuoteNotfoundException(Throwable cause) {
		super(cause);
	}

	public QuoteNotfoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public QuoteNotfoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		}

}
