package com.joinsolutions.curso_demo_spring_boot_mongodb.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.User;
import com.joinsolutions.curso_demo_spring_boot_mongodb.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll(){		
		return userRepository.findAll();
	};	
	
}
