package com.example.webapplication.repository;

import com.example.webapplication.model.Movie;
import com.example.webapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM user u WHERE u.username = ?1")
    Optional<User> findUserByUsername(String username);
}
