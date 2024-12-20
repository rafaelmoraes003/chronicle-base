package com.educandoweb.chroniclebase.services;

import com.educandoweb.chroniclebase.dto.AuthorDTO;
import com.educandoweb.chroniclebase.dto.CommentDTO;
import com.educandoweb.chroniclebase.entities.Post;
import com.educandoweb.chroniclebase.entities.User;
import com.educandoweb.chroniclebase.repository.PostRepository;
import com.educandoweb.chroniclebase.repository.UserRepository;
import com.educandoweb.chroniclebase.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

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

    public Post insert(Post postData, User author) {
        Post newPost = new Post(
                null,
                Instant.now(),
                postData.getTitle(),
                postData.getBody(),
                new AuthorDTO(author)
        );

        return postRepository.insert(newPost);
    }

    public void delete(String id) {
        findById(id);
        postRepository.deleteById(id);
    }

    public Post update(String id, Post postData) {
        Post post = findById(id);
        post.setTitle(postData.getTitle());
        post.setBody(postData.getBody());
        return save(post);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

}
