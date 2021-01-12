package com.desafio.backend.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.desafio.backend.entities.User;
import com.desafio.backend.repositories.UserRepository;
import com.desafio.backend.security.UserSS;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByUsername(username);
		
		if(!user.isPresent())
			throw new UsernameNotFoundException(username);
		
		return new UserSS(user.get().getId()
				,user.get().getUsername()
				,user.get().getPassword(),user.get().getAccountTypes());
	}

}
