package com.desafio.backend.entities.enums;

import java.util.Objects;

public enum AccountType {
	
	ADMIN(1,"ROLE_ADMIN"),
	COMUM(2,"ROLE_COMMON");
	
	private int code;
	private String role;
	
	private AccountType(int code, String role) {
		this.code = code;
		this.role = role;
	}

	public int getCode() {
		return code;
	}

	public String getRole() {
		return role;
	}
	
	public static AccountType toEnum(Integer code) {
		
		if(Objects.isNull(code))
			return null;
		
		for(AccountType x : AccountType.values()) {
			if(code.equals(x.getCode())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("The Id is not valid!");
	}
	
	

}