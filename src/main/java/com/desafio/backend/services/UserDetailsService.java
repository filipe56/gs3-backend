package com.desafio.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.desafio.backend.security.JWTUtil;
import com.desafio.backend.security.UserSS;

@Service
public class UserDetailsService {
	
	@Autowired
	private JWTUtil util;
	
	public String getUser(String token) {
			return getUserAuthenticated().getUsername();
	}
	
	public static UserSS getUserAuthenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;
		}
		
	}
}
