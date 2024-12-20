package com.educandoweb.chroniclebase.resources;

import com.educandoweb.chroniclebase.dto.CommentDTO;
import com.educandoweb.chroniclebase.entities.Post;
import com.educandoweb.chroniclebase.resources.util.URL;
import com.educandoweb.chroniclebase.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Post> update(@PathVariable String id, @RequestBody Post postData) {
        Post post = postService.update(id, postData);
        return ResponseEntity.status(HttpStatus.OK).body(post);
    }

    @PostMapping(value = "/{post_id}/comment/{user_id}")
    public ResponseEntity<Post> insertComment(
            @PathVariable("post_id") String postId,
            @PathVariable("user_id") String userId,
            @RequestBody CommentDTO comment
    ) {
        Post post = postService.insertComment(postId, userId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(post);
    }

    @GetMapping(value = "/full-search")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "min_date", defaultValue = "") String minDate,
            @RequestParam(value = "max_date", defaultValue = "") String maxDate
    ) {
        text = URL.decodeParam(text);
        Instant min = URL.convertDate(minDate, Instant.EPOCH);
        Instant max = URL.convertDate(maxDate, Instant.now());

        List<Post> posts = postService.fullSearch(text, min, max);
        return ResponseEntity.status(HttpStatus.OK).body(posts);
    }
}

