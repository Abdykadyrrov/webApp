package com.example.webapplication.service;

import com.example.webapplication.model.Movie;
import com.example.webapplication.model.User;
import com.example.webapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }
    public Optional<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public void delete(User user){
        userRepository.delete(user);
    }
    public void create(User user){
        userRepository.save(user);
    }

}
