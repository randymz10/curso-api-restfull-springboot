package com.example.curso.oauth2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.curso.oauth2.entity.User;
import com.example.curso.oauth2.service.IUserService;

@RestController
@RequestMapping("/api")
public class UserRestController {
    
    @Autowired
    private IUserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/users")
    public ResponseEntity<?> obtenerUsuarios(){
        List<User> users = userService.findAll();

        if(users != null){
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/create_user")
    public ResponseEntity<?> create(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        this.userService.save(user);
        
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
