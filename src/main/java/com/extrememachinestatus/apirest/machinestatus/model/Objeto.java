package com.extrememachinestatus.apirest.machinestatus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Objetos")
public class Objeto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idObjeto;

    private String nombre;

    private String descripcion;

    private String estadoRegistro;

    private Long estadoInicial_Id;

    private Long estadoFinal_Id;

    public Long getIdEstado() {
        return idObjeto;
    }

    public void setIdEstado(Long idEstado) {
        this.idObjeto = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public Long getEstadoInicial_Id() {
        return estadoInicial_Id;
    }

    public void setEstadoInicial_Id(Long estadoInicial_Id) {
        this.estadoInicial_Id = estadoInicial_Id;
    }

    public Long getEstadoFinal_Id() {
        return estadoFinal_Id;
    }

    public void setEstadoFinal_Id(Long estadoFinal_Id) {
        this.estadoFinal_Id = estadoFinal_Id;
    }
    
}
