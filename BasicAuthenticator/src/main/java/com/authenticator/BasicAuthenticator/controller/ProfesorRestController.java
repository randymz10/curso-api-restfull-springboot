package com.authenticator.BasicAuthenticator.controller;

import com.authenticator.BasicAuthenticator.entity.Profesor;
import com.authenticator.BasicAuthenticator.service.ProfesorServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController    
public class ProfesorRestController {
    @Autowired
    ProfesorServiceImpl profesorService;
    
    @RequestMapping(value = "/todos_profesores_public", method = RequestMethod.GET)
    public ResponseEntity<List<Profesor>> listAllProfessor(){
        List<Profesor> profesores = profesorService.findAllProfesors();
        if(profesores.isEmpty()){
            return new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/todos_profesores_admin", method = RequestMethod.GET)
    public ResponseEntity<List<Profesor>> listAllProfessorAdmin(){
        List<Profesor> profesores = profesorService.findAllProfesors();
        if(profesores.isEmpty()){
            return new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/todos_profesores_user", method = RequestMethod.GET)
    public ResponseEntity<List<Profesor>> listAllProfessorUser(){
        List<Profesor> profesores = profesorService.findAllProfesors();
        if(profesores.isEmpty()){
            return new ResponseEntity<List<Profesor>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Profesor>>(profesores, HttpStatus.OK);
    }
}
