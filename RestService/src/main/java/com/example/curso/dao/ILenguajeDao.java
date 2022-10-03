package com.example.curso.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.curso.entity.Lenguaje;

import org.springframework.data.jpa.repository.Query;

public interface ILenguajeDao extends CrudRepository<Lenguaje, Long>{
    
    @Query("select l from Lenguaje l where l.id=?1")
    public Lenguaje findBySQL(Long id);
    
}