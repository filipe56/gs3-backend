package com.desafio.backend.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.desafio.backend.entities.Address;
import com.desafio.backend.entities.Clients;
import com.desafio.backend.entities.Phone;
import com.desafio.backend.entities.User;
import com.desafio.backend.repositories.ClientRepository;
import com.desafio.backend.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();
		
		set1.add(1);
		set1.add(2);
		
		set2.add(2);
		
	
		Address ad1 = new Address(null, "Qn07 conjunto 18 casa 37", "DF", "Riacho Fundo 1", "Brasília", null, "71805718", null);
		Address ad2 = new Address(null, "Qn05 conjunto 23 casa 12", "DF", "Riacho Fundo 1", "Brasília", null, "71805718", "Casa azul");

		
		Set<Phone> sp1 = new HashSet<>();
		Set<Phone> sp2 = new HashSet<>();
		Phone p1 = new Phone(null,"999998888","061",1);
		Phone p2 = new Phone(null,"99997777","061",2);
		sp1.add(p1);
		sp2.add(p2);
		
		Set<String> se1 = new HashSet<>();
		Set<String> se2 = new HashSet<>();
		String e1 = "raphael.gol@hotmail.com";
		String e2 = "raphael@gmail.com";
		String e3 = "raphael@yahoo.com";
		se1.add(e1);
		se2.add(e2);
		se2.add(e3);
		
		
		
		User u1 = new User(null, "admin", "123456",set1);
		User u2 = new User(null,"comum","123456",set2);
	
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Clients c1 = new Clients(null,"Raphael Magalhães", "12345678901",sp1,ad1,se1);
		Clients c2 = new Clients(null,"Walter Pereira", "78945612307",sp2,ad2,se2);
		
		clientRepository.saveAll(Arrays.asList(c1, c2));
		
	}
}
