package com.example.curso.restjwt.controller;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SecurityController {

    @GetMapping("/acceso_solo_con_jwt")
    public ResponseEntity<?> getInformacionBancaria(){
        List<String> movimientosBancarios = obtenerUltimosMoimientosBancarios();
        if(movimientosBancarios != null){
            return new ResponseEntity<>(movimientosBancarios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private List<String> obtenerUltimosMoimientosBancarios(){
        List<String> movimientosBancarios = new ArrayList<>();
        movimientosBancarios.add("20");
        movimientosBancarios.add("-20");
        movimientosBancarios.add("4520");
        movimientosBancarios.add("-520");

        return movimientosBancarios;
    }
}
