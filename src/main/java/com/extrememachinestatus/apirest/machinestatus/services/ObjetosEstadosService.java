
package com.extrememachinestatus.apirest.machinestatus.services;

import com.extrememachinestatus.apirest.machinestatus.commons.ResponseWebApi;
import com.extrememachinestatus.apirest.machinestatus.model.ObjetosEstados;
import com.extrememachinestatus.apirest.machinestatus.repository.IObjetosEstados;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetosEstadosService {
    
    @Autowired
    private IObjetosEstados _objetosEstadosRepository;
    
    public ResponseWebApi create(ObjetosEstados objetoEstado) {
        ResponseWebApi response = new ResponseWebApi();
        ObjetosEstados result = null;
        try {
            
            // Validamos si existe un objeto con el mismo nombre
            result = null;// _objetosEstadosRepository.findByEstadoIdAndObjetoId(objetoEstado.getEstado_id(), objetoEstado.getObjeto_id());
            if(result != null)
                throw new Exception("Ya existe la relacion entre objeto y estado.");
            
            result = _objetosEstadosRepository.save(objetoEstado);

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
    
    public ResponseWebApi update(Long id, ObjetosEstados objetoEstado) {
        ResponseWebApi response = new ResponseWebApi();

        // Validamos si el objeto a eliminar existe
        ObjetosEstados existeObjeto = (ObjetosEstados) this.getById(id).getData();

        try {
            if(existeObjeto == null)
                throw new Exception("El objeto a modificar no existe");
            
            // existeObjeto.setEstado_id(objetoEstado.getEstado_id());
            // existeObjeto.setObjeto_id(objetoEstado.getObjeto_id());
            existeObjeto.setEstadoRegistro(objetoEstado.getEstadoRegistro());
            
            _objetosEstadosRepository.save(existeObjeto);

            response.setStatus(true);
            response.setMessage("Registro encontrado");
            response.setData(existeObjeto);
            
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
        Optional<ObjetosEstados> result = null;
        try {
            result = _objetosEstadosRepository.findById(id);

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
        List<ObjetosEstados> result = null;
        try {
            result = _objetosEstadosRepository.findAll();
            
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
        ObjetosEstados existeObjeto = (ObjetosEstados) this.getById(id).getData();
        try {
            if(existeObjeto == null)
                throw new Exception("El objeto a eliminar no existe");

            _objetosEstadosRepository.deleteById(id);
            
            response.setStatus(true);
            response.setMessage("Registro eliminado correctamente");
            response.setData(existeObjeto);
            
        } catch (Exception e) {
            response.setStatus(false);
            response.setMessage(e.getMessage());
            response.setData(null);
        }
        return response;
    }
    
}
