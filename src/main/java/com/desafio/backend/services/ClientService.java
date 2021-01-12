package com.desafio.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.backend.entities.Clients;
import com.desafio.backend.repositories.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository repository;
	
	
	public List<Clients> findAll(){
		return repository.findAll();
	}
	
	public Clients findById(Long id) {
		Optional<Clients> client = repository.findById(id);
		return client.get();
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Clients updateData(Long id, Clients client) {
		Clients entity = repository.getOne(id);
		updateClient(entity, client);
		return repository.save(entity);
	}
	
	public Clients insert(Clients client) {
		return repository.save(client);
	}

	
	private void updateClient(Clients entity, Clients client) {
		entity.setCpf(client.getCpf());
		entity.setName(client.getName());
		entity.setAddresses(client.getAddress());
		entity.setEmails(client.getEmails());
		entity.setPhones(client.getPhones());
	}
}


