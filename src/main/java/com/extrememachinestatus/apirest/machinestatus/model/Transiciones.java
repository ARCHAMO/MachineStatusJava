package com.extrememachinestatus.apirest.machinestatus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Transiciones")
public class Transiciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransicion;

    private Long estadoOrigenId;
    
    private Long estadoDestinoId;

    private Long objetoId;

    private String metodoEjecucion;

    private String parametros;
    
    private String estadoRegistro;

    public Long getIdTransicion() {
        return idTransicion;
    }

    public void setIdTransicion(Long idTransicion) {
        this.idTransicion = idTransicion;
    }

    public Long getEstadoOrigenId() {
        return estadoOrigenId;
    }

    public void setEstadoOrigenId(Long estadoOrigenId) {
        this.estadoOrigenId = estadoOrigenId;
    }

    public Long getEstadoDestinoId() {
        return estadoDestinoId;
    }

    public void setEstadoDestinoId(Long estadoDestinoId) {
        this.estadoDestinoId = estadoDestinoId;
    }

    public Long getObjetoId() {
        return objetoId;
    }

    public void setObjetoId(Long objetoId) {
        this.objetoId = objetoId;
    }

    public String getMetodoEjecucion() {
        return metodoEjecucion;
    }

    public void setMetodoEjecucion(String metodoEjecucion) {
        this.metodoEjecucion = metodoEjecucion;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
}
