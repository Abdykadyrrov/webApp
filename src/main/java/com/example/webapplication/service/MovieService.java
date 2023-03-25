package com.example.webapplication.service;

import com.example.webapplication.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    public List<Movie> getMovies(){
        return List.of(new Movie(1L,"Harry Potter","J.K. Rowling", 1255 ));
    }

}
