package com.example.webapplication.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long id;
    private String name;
    private String author;
    private Integer year;

    public Movie() {
    }

    public Movie(Long id, String name, String author, Integer year) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public Movie(String name, String author, Integer year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }
}
