package com.sandov.exception;

public class RefactorException extends Exception{
	
	private String code;
	private String message;
	private Exception rootCause;

	public RefactorException(String message) {
		super(message);
		this.message = message;
	}

	public RefactorException(String code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}

	public RefactorException(Exception rootCause) {
		this.rootCause = rootCause;
		this.message = rootCause.getMessage();
	}

	public RefactorException(String message, Exception rootCause) {
		super(message, rootCause);
		this.message = message;
		this.rootCause = rootCause;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getRootCause() {
		return rootCause;
	}

	public void setRootCause(Exception rootCause) {
		this.rootCause = rootCause;
	}
}
