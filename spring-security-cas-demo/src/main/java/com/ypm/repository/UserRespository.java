package com.ypm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ypm.model.User;
public interface UserRespository  extends JpaRepository<User, Integer>{
	
	User findByUsername(String username);
	
}
