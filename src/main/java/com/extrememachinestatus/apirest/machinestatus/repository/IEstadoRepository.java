package com.extrememachinestatus.apirest.machinestatus.repository;

import com.extrememachinestatus.apirest.machinestatus.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstadoRepository extends JpaRepository<Estado, Long>{
    public Estado findByNombre(String nombre);
}
