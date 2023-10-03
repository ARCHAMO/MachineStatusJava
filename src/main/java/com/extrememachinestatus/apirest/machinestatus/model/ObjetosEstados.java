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

    private int objetoId;

    private int estadoId;

    private String estadoRegistro;
    
    public void setIdObjetoEstado(Long idObjetoEstado) {
        this.idObjetoEstado = idObjetoEstado;
    }

    public int getObjeto_id() {
        return objetoId;
    }

    public void setObjeto_id(int objetoId) {
        this.objetoId = objetoId;
    }

    public int getEstado_id() {
        return estadoId;
    }

    public void setEstado_id(int estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

}
