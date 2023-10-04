package com.extrememachinestatus.apirest.machinestatus.repository;

import com.extrememachinestatus.apirest.machinestatus.model.Transiciones;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransicionesRepository extends JpaRepository<Transiciones, Long>{
    
}
