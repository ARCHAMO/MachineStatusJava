package com.extrememachinestatus.apirest.machinestatus.services;

import com.extrememachinestatus.apirest.machinestatus.commons.ResponseWebApi;
import com.extrememachinestatus.apirest.machinestatus.model.Transiciones;
import com.extrememachinestatus.apirest.machinestatus.repository.ITransicionesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransicionesService {
    
    @Autowired
    private ITransicionesRepository _transicionesRepository;
    
    public ResponseWebApi create(Transiciones transicion) {
        ResponseWebApi response = new ResponseWebApi();
        Transiciones result = null;
        try {
            
            result = _transicionesRepository.save(transicion);

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
    
    public ResponseWebApi update(Long id, Transiciones transicion) {
        ResponseWebApi response = new ResponseWebApi();

        // Validamos si el objeto a eliminar existe
        Transiciones existeTransicion = (Transiciones) this.getById(id).getData();

        try {
            if(existeTransicion == null)
                throw new Exception("El transicion no existe");
            
            existeTransicion.setEstadoOrigenId(transicion.getEstadoOrigenId());
            existeTransicion.setEstadoDestinoId(transicion.getEstadoDestinoId());
            existeTransicion.setEstadoRegistro(transicion.getEstadoRegistro());
            existeTransicion.setMetodoEjecucion(transicion.getMetodoEjecucion());
            existeTransicion.setParametros(transicion.getParametros());

            
            _transicionesRepository.save(existeTransicion);

            response.setStatus(true);
            response.setMessage("Registro modificado correctamento");
            response.setData(existeTransicion);
            
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
        Optional<Transiciones> result = null;
        try {
            result = _transicionesRepository.findById(id);

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
        List<Transiciones> result = null;
        try {
            result = _transicionesRepository.findAll();
            
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
        Transiciones existeEstado = (Transiciones) this.getById(id).getData();
        try {
            if(existeEstado == null)
                throw new Exception("El estado a eliminar no existe");

            _transicionesRepository.deleteById(id);
            
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
    
}
