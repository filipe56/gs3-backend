package com.desafio.backend.entities.enums;

public enum PhoneType {

	RESIDENTIAL_NUMBER(0),
	MOBILE_NUMBER(1),
	WORKING_NUMBER(3);
	
	private int code;
	
	private PhoneType(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static PhoneType valueOf(int code) {
		for(PhoneType value : PhoneType.values()) {
			if(value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid PhoneType code");
	}
	
}
