package com.ds.ds_test.controller;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ds.ds_test.entity.User;
import com.ds.ds_test.service.UserService;

@RestController
@RequestMapping(value = "api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("update")
	public ResponseEntity<User> update(
				@RequestParam(value="u_idx") int u_idx,
				@RequestParam(value="u_id") String u_id,
				@RequestParam(value="u_pw") String u_pw,
				@RequestParam(value="u_nick") String u_nick
			) {
		
		Optional<User> op = userService.findByUidx(u_idx);
		
		if(op.isPresent()) {
			op.get().setUid(u_id);
			op.get().setUpw(u_pw);
			op.get().setUnick(u_nick);
			
			User updateUser = userService.saveUser(op.get());
			return ResponseEntity.ok(updateUser);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@GetMapping("uNick/{u_nick}")
	public ResponseEntity<User> findByUNick(@PathVariable(value = "u_nick") String u_nick) {
		Optional<User> op = userService.findByUnick(u_nick);
		
		if(op.isPresent()) {
			return ResponseEntity.ok(op.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@GetMapping("uIdx/{u_idx}")
	public ResponseEntity<User> findByUidx(@PathVariable(value = "u_idx") int u_idx) {
		Optional<User> op = userService.findByUidx(u_idx);
		
		if(op.isPresent()) {
			return ResponseEntity.ok(op.get());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@PostMapping("save")
	public User save(
				@RequestParam(value="u_id") String u_id,
				@RequestParam(value="u_pw") String u_pw,
				@RequestParam(value="u_nick") String u_nick
			) {
		User user = User.builder()
				.uid(u_id)
				.upw(u_pw)
				.unick(u_nick)
				.createdDate(LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS))
				.build();
		
		User savedUser = userService.saveUser(user);
		
		return savedUser;
		
	}
	
}
