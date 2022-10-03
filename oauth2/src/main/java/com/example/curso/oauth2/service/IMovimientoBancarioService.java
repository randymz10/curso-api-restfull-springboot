package com.example.curso.oauth2.service;

import java.util.List;

import com.example.curso.oauth2.entity.MovimientoBancario;

public interface IMovimientoBancarioService {
    
    public List<MovimientoBancario> findAll();

    public void save (MovimientoBancario movimientoBancario);

    public List<MovimientoBancario> getMovimientoUser(Long id);

}
