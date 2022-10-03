package com.authenticator.BasicAuthenticator.dao;

import com.authenticator.BasicAuthenticator.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfesorDao extends JpaRepository<Profesor, Long>{
    
}
