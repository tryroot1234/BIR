package com.oracle.bir.Exception;

public class LoginException extends Exception {

	private static final long serialVersionUID = 4665058065491711297L;

	public LoginException() {
		super();
	}

	public LoginException(String message) {
		super(message);
	}

	public LoginException(Throwable cause) {
		super(cause);
	}

}
