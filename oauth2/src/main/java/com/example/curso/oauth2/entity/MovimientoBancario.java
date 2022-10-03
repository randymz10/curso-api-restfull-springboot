package com.example.curso.oauth2.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "movimiento_bancario")
public class MovimientoBancario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    
    private String importe;
    
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        private static final long serialVersionUID = 1L;
}
