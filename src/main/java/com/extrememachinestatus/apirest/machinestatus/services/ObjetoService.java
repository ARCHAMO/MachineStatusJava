
package com.extrememachinestatus.apirest.machinestatus.services;

import com.extrememachinestatus.apirest.machinestatus.commons.ResponseWebApi;
import com.extrememachinestatus.apirest.machinestatus.model.Objeto;
import com.extrememachinestatus.apirest.machinestatus.repository.IObjetoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObjetoService {
    
    @Autowired
    private IObjetoRepository _objetoRepository;
    
    public ResponseWebApi create(Objeto objeto) {
        ResponseWebApi response = new ResponseWebApi();
        Objeto result = null;
        try {
            
            // Validamos si existe un objeto con el mismo nombre
            result = _objetoRepository.findByNombre(objeto.getNombre());
            if(result != null)
                throw new Exception("El nombre del objeto ya esta siendo utilizado.");
            
            result = _objetoRepository.save(objeto);

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
    
    public ResponseWebApi update(Long id, Objeto objeto) {
        ResponseWebApi response = new ResponseWebApi();

        // Validamos si el objeto a eliminar existe
        Objeto existeObjeto = (Objeto) this.getById(id).getData();

        try {
            if(existeObjeto == null)
                throw new Exception("El objeto a modificar no existe");
            
            existeObjeto.setNombre(objeto.getNombre());
            existeObjeto.setEstadoRegistro(objeto.getEstadoRegistro());
            existeObjeto.setDescripcion(objeto.getDescripcion());
            existeObjeto.setEstadoInicial_Id(objeto.getEstadoInicial_Id());
            existeObjeto.setEstadoFinal_Id(objeto.getEstadoFinal_Id());
            
            _objetoRepository.save(existeObjeto);

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
        Optional<Objeto> result = null;
        try {
            result = _objetoRepository.findById(id);

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
        List<Objeto> result = null;
        try {
            result = _objetoRepository.findAll();
            
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
        Objeto existeObjeto = (Objeto) this.getById(id).getData();
        try {
            if(existeObjeto == null)
                throw new Exception("El objeto a eliminar no existe");

            _objetoRepository.deleteById(id);
            
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
