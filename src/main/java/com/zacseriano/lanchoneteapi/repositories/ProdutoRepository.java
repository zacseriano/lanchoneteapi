package com.zacseriano.lanchoneteapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zacseriano.lanchoneteapi.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	Produto findById(long id);
}