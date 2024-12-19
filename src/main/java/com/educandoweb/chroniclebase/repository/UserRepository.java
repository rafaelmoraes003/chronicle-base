package com.educandoweb.chroniclebase.repository;

import com.educandoweb.chroniclebase.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
