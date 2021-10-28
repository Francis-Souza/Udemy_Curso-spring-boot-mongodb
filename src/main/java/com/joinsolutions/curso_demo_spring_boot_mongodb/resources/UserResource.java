package com.joinsolutions.curso_demo_spring_boot_mongodb.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.User;
import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.services.UserService;
import com.joinsolutions.curso_demo_spring_boot_mongodb.dto.UserDTO;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {		
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map( x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	};

}
