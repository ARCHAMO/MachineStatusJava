package com.extrememachinestatus.apirest.machinestatus.repository;

import com.extrememachinestatus.apirest.machinestatus.model.ObjetosEstados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IObjetosEstados extends JpaRepository<ObjetosEstados, Long>{
    public ObjetosEstados findByEstadoIdAndObjetoId(int estado_Id, int objeto_Id);
}
