package com.example.curso.controller;

import com.example.curso.entity.Lenguaje;
import com.example.curso.service.ILenguajeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LenguajeRestController {

    @Autowired
    private ILenguajeService lenguajeService;

    @GetMapping("/lenguaje")
    public ResponseEntity<?> listaLEnguajes() {
        List<Lenguaje> listaLenguajes = lenguajeService.findAll();
        if (listaLenguajes != null) {
            if (!listaLenguajes.isEmpty()) {
                return new ResponseEntity<>(listaLenguajes, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/crear_lenguaje")
    public ResponseEntity<?> agregarLenguaje(@RequestBody Lenguaje lenguaje){
        lenguajeService.saveLenguaje(lenguaje);
        
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
