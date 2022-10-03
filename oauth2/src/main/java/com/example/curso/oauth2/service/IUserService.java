package com.example.curso.oauth2.service;

import java.util.List;

import com.example.curso.oauth2.entity.User;

public interface IUserService {
    
    public List<User> findAll();

    public void save (User user);

    public User findById(Long id);
}
