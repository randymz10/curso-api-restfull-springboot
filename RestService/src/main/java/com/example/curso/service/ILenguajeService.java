package com.example.curso.service;

import com.example.curso.entity.Lenguaje;
import java.util.List;

public interface ILenguajeService {
    public List<Lenguaje> findAll();
    
    public void saveLenguaje (Lenguaje lenguaje);
    
    public Lenguaje findLenguajeByID(Long id);
}
