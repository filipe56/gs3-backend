package com.desafio.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.backend.entities.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
