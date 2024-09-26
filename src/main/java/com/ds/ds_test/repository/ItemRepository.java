package com.ds.ds_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.ds_test.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
	
}
