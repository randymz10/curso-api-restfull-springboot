package com.example.curso.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.curso.entity.Profesor;
import com.example.curso.mapper.Mapper;
import com.example.curso.model.MProfesor;
import com.example.curso.service.IProfesorService;

@RestController
@RequestMapping("/api")
public class ProfesorRestController {
    
    @Autowired
    private IProfesorService profesorService;

    @GetMapping("/profesores")
    @ResponseStatus(HttpStatus.OK)
    public List<Profesor> getProfesores(){
        return profesorService.findAll();
    }

    @PostMapping("/find_profesor")
    public ResponseEntity<?> findProfesor(@RequestBody Profesor profesor){
        Profesor profesorDb = profesorService.findProfesor(profesor);
        if(profesorDb != null){
            return new ResponseEntity<>(profesorDb, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/sign_up")
    public ResponseEntity<Void> addProfesor(@RequestBody Profesor profesor){
        if(profesorService.findProfesor(profesor) == null){
            profesorService.save(profesor);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }else {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> loginProfesor(@RequestBody Profesor profesor){
        Profesor profesorDb = profesorService.checkProfesorLogin(profesor);
        if(profesorDb != null){
            List<Profesor> profesores = new ArrayList<>();
            profesores.add(profesorDb);
            List<MProfesor> mProfesores = new ArrayList<>();
            mProfesores = Mapper.convertirLista(profesores);
            return new ResponseEntity<>(mProfesores, HttpStatus.OK);
        }else{
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateProfesor(@PathVariable Long id, @RequestBody Profesor profesor){
        Profesor profesorDb = profesorService.findById(id);

        if(profesorDb != null){
            profesorDb.setEmail(profesor.getEmail());
            profesorDb.setNombre(profesor.getNombre());
            profesorService.updateProfesor(profesorDb);
            return new ResponseEntity<>(profesorDb, HttpStatus.OK);
        }else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    //@PutMapping("/update_sql")
    //public ResponseEntity<?> updateProfesorSql(@RequestBody Profesor profesor){
      //  Profesor profesorDb = profesorService.findBySQl(profesor.getId());

        //if(profesorDb != null){
          //  profesorDb.setEmail(profesor.getEmail());
            //profesorDb.setNombre(profesor.getNombre());
            //profesorService.updateProfesor(profesorDb);
            //return new ResponseEntity<>(profesorDb, HttpStatus.OK);
        //}else {
          //  return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        //}
    //}

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable Long id){
        profesorService.deleteProfesor(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteAllProfesores(){
        profesorService.deleteAllProfesor();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("delete_post")
    public ResponseEntity<Void> deleteProfesorPost(@RequestBody Profesor profesor){
        if(profesorService.findProfesor(profesor) != null){
            profesorService.deleteProfesor(profesor);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
