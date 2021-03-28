package com.spring.security.repository;


import org.springframework.data.repository.CrudRepository;

import com.spring.security.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	User findUserByEmail(String email);

	
}