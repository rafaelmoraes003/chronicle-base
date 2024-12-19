package com.educandoweb.chroniclebase.repository;

import com.educandoweb.chroniclebase.entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
