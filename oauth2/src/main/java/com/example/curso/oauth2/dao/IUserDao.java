package com.example.curso.oauth2.dao;

import com.example.curso.oauth2.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserDao extends CrudRepository<User, Long>{
    
    public User findByUsername (String username);
    
}
