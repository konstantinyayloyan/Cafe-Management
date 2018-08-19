package com.cafemanagement.service;

import com.cafemanagement.entity.User;
import com.cafemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public User create(User user) {
        return userRepository.save(user);
    }




}
