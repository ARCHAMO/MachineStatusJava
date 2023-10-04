package com.extrememachinestatus.apirest.machinestatus.repository;

import com.extrememachinestatus.apirest.machinestatus.model.Estado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEstadoRepository extends JpaRepository<Estado, Long>{
    public Estado findByNombre(String nombre);

    @Query(value="Select e.* From Estados e JOIN Objetos_Estados o ON (o.ESTADO_ID = e.ID_ESTADO) Where o.Objeto_Id = ?1", nativeQuery = true)
    public List<Estado> findEstadosByObjeto(Long id);
}
