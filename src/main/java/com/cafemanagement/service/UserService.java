package com.cafemanagement.service;

import com.cafemanagement.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void deleteById(Long id);

    User create(User user);

    User edit(User user);
}
