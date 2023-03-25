package com.example.webapplication.service;

import com.example.webapplication.model.Movie;
import com.example.webapplication.repository.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieOptional = movieRepository
                .findMoviesByNameAndAuthor(movie.getName(),movie.getAuthor());
        if (movieOptional.isPresent()){
            throw new IllegalStateException("this movie is exist");
        }
        movieRepository.save(movie);
    }

    public void deleteMovie(Long movieId) {
        boolean exist = movieRepository.existsById(movieId);
        if(!exist){
            throw new IllegalStateException("movie with id "+ movieId +" is not exist");
        }
        movieRepository.deleteById(movieId);
    }
    @Transactional
    public void updateMovie(Long movieId, String name, String author, Integer year) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalStateException("movie with id " + movieId + "does mot exist"));

        if (name != null && !Objects.equals(movie.getName(),name)){
            movie.setName(name);
        }

        if (author != null && !Objects.equals(movie.getAuthor(),author)){
            movie.setAuthor(author);
        }
        if (year != null && !Objects.equals(movie.getYear(),year)){
            movie.setYear(year);
        }
    }
}
