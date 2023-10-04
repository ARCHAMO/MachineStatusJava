package com.extrememachinestatus.apirest.machinestatus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ObjetosEstados")
public class ObjetosEstados {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjetoEstado;

    private Long objetoId;

    private Long estadoId;

    private String estadoRegistro;
    
    public void setIdObjetoEstado(Long idObjetoEstado) {
        this.idObjetoEstado = idObjetoEstado;
    }

    public Long getObjetoId() {
        return objetoId;
    }

    public void setObjetoId(Long objetoId) {
        this.objetoId = objetoId;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

}
