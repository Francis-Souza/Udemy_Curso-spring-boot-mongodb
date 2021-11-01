package com.joinsolutions.curso_demo_spring_boot_mongodb.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.Post;
import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.services.PostService;
import com.joinsolutions.curso_demo_spring_boot_mongodb.resources.util.URL;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findbyId(@PathVariable String id) {		
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);
	};


	@GetMapping(value = "/posts/titlesearch")
	public ResponseEntity<List<Post>> findbyTitle(@RequestParam(value="text", defaultValue = "") String text) {		
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);
	};

	
}
