package com.extrememachinestatus.apirest.machinestatus.services;

import com.extrememachinestatus.apirest.machinestatus.commons.ResponseWebApi;
import com.extrememachinestatus.apirest.machinestatus.model.Estado;
import com.extrememachinestatus.apirest.machinestatus.repository.IEstadoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {
    
    @Autowired
    private IEstadoRepository _estadoRepository;
    
    public ResponseWebApi create(Estado estado) {
        ResponseWebApi response = new ResponseWebApi();
        Estado result = null;
        try {
            
            // Validamos si existe un objeto con el mismo nombre
            result = _estadoRepository.findByNombre(estado.getNombre());
            if(result != null)
                throw new Exception("El nombre del estado ya esta siendo utilizado.");
            
            result = _estadoRepository.save(estado);

            response.setStatus(true);
            response.setMessage("Registro creado correctamente");
            response.setData(result);
            
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        } finally {
            
        }
        return response;
    }
    
    public ResponseWebApi update(Long id, Estado estado) {
        ResponseWebApi response = new ResponseWebApi();

        // Validamos si el objeto a eliminar existe
        Estado existeEstado = (Estado) this.getById(id).getData();

        try {
            if(existeEstado == null)
                throw new Exception("El estado a modificar no existe");
            
            existeEstado.setNombre(estado.getNombre());
            existeEstado.setEstadoRegistro(estado.getEstadoRegistro());
            existeEstado.setDescripcion(estado.getDescripcion());
            
            _estadoRepository.save(existeEstado);

            response.setStatus(true);
            response.setMessage("Registro modificado correctamento");
            response.setData(existeEstado);
            
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        } finally {
            
        }
        return response;
    }
    
    public ResponseWebApi getById(Long id) {
        ResponseWebApi response = new ResponseWebApi();
        Optional<Estado> result = null;
        try {
            result = _estadoRepository.findById(id);

            response.setStatus(true);
            response.setMessage(result == null ? "Registro no encontrado" : "Registro encontrado");
            response.setData(result);
            
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        } finally {
            
        }
        return response;
    }
    
    public ResponseWebApi getAll() {
        ResponseWebApi response = new ResponseWebApi();
        List<Estado> result = null;
        try {
            result = _estadoRepository.findAll();
            
            response.setStatus(true);
            response.setMessage(result.size() + " registro encontrado");
            response.setData(result);
            
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        } finally {
            
        }
        return response;
    }
    
    public ResponseWebApi delete(Long id) {
        ResponseWebApi response = new ResponseWebApi();
        // Validamos si el objeto a eliminar existe
        Estado existeEstado = (Estado) this.getById(id).getData();
        try {
            if(existeEstado == null)
                throw new Exception("El estado a eliminar no existe");

            _estadoRepository.deleteById(id);
            
            response.setStatus(true);
            response.setMessage("Registro eliminado correctamente");
            response.setData(existeEstado);
            
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        }
        return response;
    }
    
    public ResponseWebApi getEstadosPorObjeto(Long idObjeto) {
        ResponseWebApi response = new ResponseWebApi();
        List<Estado> result = null;
        try {
            result = _estadoRepository.findEstadosByObjeto(idObjeto);
            
            response.setStatus(true);
            response.setMessage(result.size() + " registro encontrado");
            response.setData(result);
            
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        } finally {
            
        }
        return response;
    }
    
}
