package com.extrememachinestatus.apirest.machinestatus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "Estados")
public class Estado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstado;

    private String nombre;

    private String descripcion;

    private String estadoRegistro;
    
//    @OneToMany(targetEntity = ObjetosEstados.class, fetch = FetchType.LAZY, mappedBy = "estado")
//    private List<ObjetosEstados> objetosEstados;
    
    //@ManyToMany(targetEntity = Object.class, fetch = FetchType.LAZY)
    @JoinTable(name = "Objetos", joinColumns = @JoinColumn(name = "estadoId"), inverseJoinColumns = @JoinColumn(name = "objetoId"))
    //private List<Objeto> objeto;

    public Long getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Long idEstado) {
        this.idEstado = idEstado;
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
}
