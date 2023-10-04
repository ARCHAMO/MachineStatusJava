package com.extrememachinestatus.apirest.machinestatus.repository;

import com.extrememachinestatus.apirest.machinestatus.model.Estado;
import com.extrememachinestatus.apirest.machinestatus.model.ObjetosEstados;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IObjetosEstados extends JpaRepository<ObjetosEstados, Long>{
    public ObjetosEstados findByEstadoIdAndObjetoId(int estado_Id, int objeto_Id);
}
