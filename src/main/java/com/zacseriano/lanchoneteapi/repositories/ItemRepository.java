package com.zacseriano.lanchoneteapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zacseriano.lanchoneteapi.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	Item findById(long id);
}
