
package com.extrememachinestatus.apirest.machinestatus.repository;

import com.extrememachinestatus.apirest.machinestatus.model.Objeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IObjetoRepository extends JpaRepository<Objeto, Long>{
    public Objeto findByNombre(String nombre);
}
