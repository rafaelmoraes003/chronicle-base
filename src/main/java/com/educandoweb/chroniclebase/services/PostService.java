package com.educandoweb.chroniclebase.services;

import com.educandoweb.chroniclebase.entities.Post;
import com.educandoweb.chroniclebase.repository.PostRepository;
import com.educandoweb.chroniclebase.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);

        if (post.isEmpty()) {
            throw new ObjectNotFoundException("post not found.");
        }

        return post.get();
    }

    public List<Post> findByTitle(String text) {
        return postRepository.findByTitleContainingIgnoreCase(text);
    }
}
