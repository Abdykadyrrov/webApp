package com.example.webapplication.controller;

import com.example.webapplication.model.Movie;
import com.example.webapplication.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    private final MovieService movieService;
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/m")
    public String getMovies(Model model){
        List<Movie> movies = List.of(new Movie(1L,"DS","sd",4343));
        model.addAttribute("movies",movies);
        return "index"; // Here, you are returning the name of the template file with the model object
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
