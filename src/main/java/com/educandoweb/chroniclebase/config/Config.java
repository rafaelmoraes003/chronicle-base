package com.educandoweb.chroniclebase.config;

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

        User u1 = new User(null, "Maria Brown", "maria@gmail.com");
        User u2 = new User(null, "Alex Green", "alex@gmail.com");
        User u3 = new User(null, "Bob Grey", "bob@gmail.com");

        Post p1 = new Post(
                null,
                Instant.now(),
                "Trip to New York",
                "I'm traveling to New York. Cheers!",
                u1
        );

        Post p2 = new Post(
                null,
                Instant.now(),
                "Good morning",
                "Woke up happy today!",
                u1
        );

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        postRepository.saveAll(Arrays.asList(p1, p2));
    }
}