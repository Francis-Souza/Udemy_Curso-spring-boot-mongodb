package com.joinsolutions.curso_demo_spring_boot_mongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.Post;
import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.User;
import com.joinsolutions.curso_demo_spring_boot_mongodb.dto.AuthorDTO;
import com.joinsolutions.curso_demo_spring_boot_mongodb.repositories.PostRepository;
import com.joinsolutions.curso_demo_spring_boot_mongodb.repositories.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

				
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("21/03/2018"), "Bom Dia", "Acordei feliz hoje!",new AuthorDTO(maria));

	
		postRepository.saveAll(Arrays.asList(post1, post2));

	}

}
