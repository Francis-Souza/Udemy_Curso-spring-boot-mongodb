package com.joinsolutions.curso_demo_spring_boot_mongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.User;
import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll() {		
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	};

}
