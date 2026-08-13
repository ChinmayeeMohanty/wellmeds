package com.cm.med_app.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cm.med_app.model.User;

public interface  UserRepository extends MongoRepository<User, String>{
	
	 Optional<User> findByUserName(String userName);
	
}
