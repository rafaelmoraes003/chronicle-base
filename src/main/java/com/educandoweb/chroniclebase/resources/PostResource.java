package com.educandoweb.chroniclebase.resources;

import com.educandoweb.chroniclebase.dto.CommentDTO;
import com.educandoweb.chroniclebase.entities.Post;
import com.educandoweb.chroniclebase.resources.util.URL;
import com.educandoweb.chroniclebase.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService postService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post post = postService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "title", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> posts = postService.findByTitle(text);
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        postService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
