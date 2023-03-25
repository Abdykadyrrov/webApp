package com.example.webapplication.controller;

import com.example.webapplication.model.Movie;
import com.example.webapplication.service.MovieService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "movies")
public class MovieController {
    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies(){
        return movieService.getMovies();
    }
    @PostMapping
    public void addNewMovie(@RequestBody Movie movie){
        movieService.addNewMovie(movie);
    }
    @DeleteMapping(path = "{movieId}")
    public void deleteMovie(@PathVariable("movieId") Long movieId){
        movieService.deleteMovie(movieId);
    }
    @PostMapping(path = "{movieId}")
    public void updateMovie(
            @PathVariable("movieId") Long movieId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer year){
        movieService.updateMovie(movieId, name, author, year);
    }
}
