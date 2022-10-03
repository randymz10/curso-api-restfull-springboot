package com.example.curso.service;

import com.example.curso.entity.Lenguaje;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.curso.dao.ILenguajeDao;

@Service
public class LenguajeService implements ILenguajeService {

    @Autowired
    private ILenguajeDao lenguajeDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Lenguaje> findAll() {
        return (List<Lenguaje>) lenguajeDao.findAll();
    }

    @Override
    @Transactional
    public void saveLenguaje(Lenguaje lenguaje) {
        lenguajeDao.save(lenguaje);
    }

    @Transactional(readOnly = true)
    public Lenguaje findLenguajeByID(Long id) {
        return lenguajeDao.findBySQL(id);
    
    }
    
}
