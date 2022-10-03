package com.example.curso.controller;

import com.example.curso.entity.*;
import com.example.curso.model.ProfesorLenguaje;
import com.example.curso.service.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProfesoreLenguajesRestController {

    @Autowired
    private ILenguajeService lenguajeService;

    @Autowired
    private IProfesorService profesorService;

    @PostMapping("lenguajes_profesor")
    public ResponseEntity<?> listaLenguajesProfesor(@RequestBody Profesor profesor) {
        Profesor profesorDb = profesorService.findById(profesor.getId());
        if (profesorDb != null) {
            Collection<Lenguaje> listaLenguajes = profesorDb.getLenguajes();
            if (listaLenguajes != null) {
                return new ResponseEntity<>(listaLenguajes, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/save_lenguaje_profesor")
    public ResponseEntity<?> saveLenguajeProfesor(@RequestBody ProfesorLenguaje profesorLenguaje){
        Profesor profesorDb = profesorService.findById(profesorLenguaje.getProfesor().getId());
        if(profesorDb != null){
            Lenguaje lenguajeDb = lenguajeService.findLenguajeByID(profesorLenguaje.getLenguaje().getId());
            profesorDb.addLenguaje(lenguajeDb);
            profesorService.save(profesorDb);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }
}
