package com.example.curso.oauth2.controller;

import com.example.curso.oauth2.entity.MovimientoBancario;
import com.example.curso.oauth2.entity.User;
import com.example.curso.oauth2.service.IMovimientoBancarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/oauth2")
public class MovimientoBancarioRestController {
    
    @Autowired
    private IMovimientoBancarioService movimientoBancarioService;
    
    @GetMapping("/movimiento_bancario")
    public ResponseEntity<?> movimientos(){
        List<MovimientoBancario> movimientosBancarios = movimientoBancarioService.findAll();
        if(movimientosBancarios != null){
            return new ResponseEntity<>(movimientosBancarios, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/movimiento_bancario_user")
    public ResponseEntity<?> movimientosUser(@RequestBody User user) {
        List<MovimientoBancario> movimientosBancarios = movimientoBancarioService.getMovimientoUser(user.getId());
        if(movimientosBancarios != null){
            return new ResponseEntity<>(movimientosBancarios, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
