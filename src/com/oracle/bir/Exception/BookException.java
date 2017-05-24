package com.oracle.bir.Exception;

public class BookException extends Exception {

	private static final long serialVersionUID = -7436165341916801501L;

	public BookException() {
		super();
	}

	public BookException(String message) {
		super(message);
	}

	public BookException(Throwable cause) {
		super(cause);
	}

}
