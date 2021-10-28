package com.joinsolutions.curso_demo_spring_boot_mongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.joinsolutions.curso_demo_spring_boot_mongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
