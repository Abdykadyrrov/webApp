package com.example.webapplication.config;

import com.example.webapplication.model.Movie;
import com.example.webapplication.repository.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MovieConfig {

    @Bean
    CommandLineRunner commandLineRunner(MovieRepository repository){
        return args -> {
            Movie harryPotter = new Movie(
                    "Harry Potter",
                    "J. K. Rowling",
                    1923
            );
            Movie mazeRunner = new Movie(
                    "Maze Runner",
                    "J. K. Rowling",
                    1923
            );

            repository.saveAll(List.of(harryPotter,mazeRunner));
        };
    }
}
