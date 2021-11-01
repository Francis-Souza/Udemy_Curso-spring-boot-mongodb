package com.joinsolutions.curso_demo_spring_boot_mongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
