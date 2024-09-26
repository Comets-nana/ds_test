package com.ds.ds_test.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ds.ds_test.entity.User;
import com.ds.ds_test.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public Optional<User> findByUnick(String u_nick) {
		return userRepository.findByUnick(u_nick);
	}
	
	public Optional<User> findByUidx(Integer u_idx) {
		return userRepository.findByUidx(u_idx);
	}
	
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
}
