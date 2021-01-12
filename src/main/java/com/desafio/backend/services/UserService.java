package com.desafio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.backend.entities.User;
import com.desafio.backend.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public User findByUsername(String username) {
		List<User> list = repository.findAll();
		for(User user : list) {
			if(user.getUsername() == username) {
				return user;
			}
		}throw new IllegalArgumentException("user does not exist");
				
	}
}
