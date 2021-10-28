package com.joinsolutions.curso_demo_spring_boot_mongodb.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.User;
import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.services.exception.ObjectNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mongodb.dto.UserDTO;
import com.joinsolutions.curso_demo_spring_boot_mongodb.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public List<User> findAll(){		
		return userRepository.findAll();
	};	
	
	
	public User findById(String id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	public User insert(User obj) {
		return userRepository.save(obj);
	}
	
	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(),objDto.getEmail());
	}
	
	public void delete(String id) {		
		findById(id);
		userRepository.deleteById(id);
	}
}
