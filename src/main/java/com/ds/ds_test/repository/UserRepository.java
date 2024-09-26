package com.ds.ds_test.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ds.ds_test.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	
	Optional<User> findByUidx(int u_idx);
	Optional<User> findByUid(String u_id);
	Optional<User> findByUnick(String u_nick);
	
}
