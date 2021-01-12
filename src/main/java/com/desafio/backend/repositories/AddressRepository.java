package com.desafio.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.backend.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
