package com.example.curso.restjwt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.curso.restjwt.model.JwtUser;
import com.example.curso.restjwt.model.Login;
import com.example.curso.restjwt.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {
    
    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator){
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping
    public ResponseEntity<?> generate(@RequestBody final Login login){
        
        JwtUser jwtUser = new JwtUser();
        jwtUser = existUser(login);
        if(jwtUser != null){
            List<String> lista = new ArrayList<>();
            lista.add(jwtGenerator.generate(jwtUser));
            return new ResponseEntity<List<String>>(lista, HttpStatus.OK);
        }else {
            return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
        }
    }

    private JwtUser existUser(Login login) {
        if(login.getUser().equals("alberto") && login.getPassword().equals("1234")){
            JwtUser jwtUser = new JwtUser(); 
            jwtUser.setUserName(login.getUser());
            jwtUser.setId(1L);
            jwtUser.setRole("Admin");

            return jwtUser;
        } else {
            return null;
        }
    }
}
 