package com.ds.ds_test.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.ds_test.ItemDto.ItemDto;
import com.ds.ds_test.entity.Item;
import com.ds.ds_test.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	public List<ItemDto> findAllItems() {
		return itemRepository.findAll().stream()
				.map(item -> new ItemDto(
						item.getIidx(),
						item.getIname(),
						item.getCreatedDate(),
						item.getUser().getUnick()
						))
				.collect(Collectors.toList());
	}
	
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}
	
}
