package com.ds.ds_test.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ds.ds_test.ItemDto.ItemDto;
import com.ds.ds_test.entity.Item;
import com.ds.ds_test.entity.User;
import com.ds.ds_test.repository.UserRepository;
import com.ds.ds_test.service.ItemService;

@RestController
@RequestMapping(value = "api/item")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("all")
	public ResponseEntity<List<ItemDto>> all() {
		List<ItemDto> items = itemService.findAllItems();
		
		for(int i=0; i<items.size(); i++) {
			
		}
		
		return ResponseEntity.ok(items);
	}
	
	@PostMapping("save")
	public ResponseEntity<Item> save(
				@RequestParam(value="u_idx") int u_idx,
				@RequestParam(value="i_name") String i_name
			) {
		
		Optional<User> user = userRepository.findByUidx(u_idx);
		
		Item item = Item.builder()
				.user(user.get())
				.iname(i_name)
				.createdDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
				.build();
		
		Item savedItem = itemService.saveItem(item);
		
		return ResponseEntity.ok(savedItem);
		
	}
	
}
