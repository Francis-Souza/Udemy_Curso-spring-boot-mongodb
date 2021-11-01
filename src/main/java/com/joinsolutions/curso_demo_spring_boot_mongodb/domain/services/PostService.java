package com.joinsolutions.curso_demo_spring_boot_mongodb.domain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.Post;
import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.services.exception.ObjectNotFoundException;
import com.joinsolutions.curso_demo_spring_boot_mongodb.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	
	public List<Post> findByTitle(String text){
		return postRepository.findByTitleContainingIgnoreCase(text);
	}
}
