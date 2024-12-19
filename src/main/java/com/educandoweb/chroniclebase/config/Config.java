package com.educandoweb.chroniclebase.config;

import com.educandoweb.chroniclebase.dto.AuthorDTO;
import com.educandoweb.chroniclebase.dto.CommentDTO;
import com.educandoweb.chroniclebase.entities.Post;
import com.educandoweb.chroniclebase.entities.User;
import com.educandoweb.chroniclebase.repository.PostRepository;
import com.educandoweb.chroniclebase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Config implements WebMvcConfigurer, CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseTrailingSlashMatch(true);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post p1 = new Post(
                null,
                Instant.now(),
                "Trip to New York",
                "I'm traveling to New York. Cheers!",
                new AuthorDTO(u1)
        );

        Post p2 = new Post(
                null,
                Instant.now(),
                "Good morning",
                "Woke up happy today!",
                new AuthorDTO(u1)
        );

        p1.getComments().addAll(Arrays.asList(
                new CommentDTO("Safe trip!", Instant.now(), new AuthorDTO(u2)),
                new CommentDTO("Enjoy!", Instant.now(), new AuthorDTO(u3))
        ));

        p2.getComments().add(new CommentDTO("Have a great day!", Instant.now(), new AuthorDTO(u2)));

        postRepository.saveAll(Arrays.asList(p1, p2));

        u1.getPosts().addAll(Arrays.asList(p1, p2));

        userRepository.save(u1);
    }
}