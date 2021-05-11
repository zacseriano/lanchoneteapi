package com.zacseriano.lanchoneteapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zacseriano.lanchoneteapi.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	Pedido findById(long id);
}

