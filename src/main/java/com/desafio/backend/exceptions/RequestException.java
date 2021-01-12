package com.desafio.backend.exceptions;

public class RequestException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public RequestException(String msg) {
		super(msg);
	}

}
