package com.zacseriano.lanchoneteapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zacseriano.lanchoneteapi.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	 Cliente findById(long id);
}
