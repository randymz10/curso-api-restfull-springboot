package com.authenticator.BasicAuthenticator.service;

import com.authenticator.BasicAuthenticator.dao.IProfesorDao;
import com.authenticator.BasicAuthenticator.entity.Profesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("profesorService")
public class ProfesorServiceImpl implements IProfesorService{

    
    @Autowired
    private IProfesorDao profesorDao;
            
    @Override
    public List<Profesor> findAllProfesors() {
        return (List<Profesor>) profesorDao.findAll();
    }
    
}
