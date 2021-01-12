package com.desafio.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.backend.entities.Clients;

public interface ClientRepository extends JpaRepository<Clients, Long>{

}
