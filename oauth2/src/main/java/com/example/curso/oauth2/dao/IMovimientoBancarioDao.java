package com.example.curso.oauth2.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.curso.oauth2.entity.MovimientoBancario;

public interface IMovimientoBancarioDao extends CrudRepository<MovimientoBancario, Long>{
    
    public List<MovimientoBancario> findByUserId(Long id);
}
