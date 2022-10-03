package com.authenticator.BasicAuthenticator.service;

import com.authenticator.BasicAuthenticator.entity.Profesor;
import java.util.List;

public interface IProfesorService {
    
    List<Profesor> findAllProfesors();
}
