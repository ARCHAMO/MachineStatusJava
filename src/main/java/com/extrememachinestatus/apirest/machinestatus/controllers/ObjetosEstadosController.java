package com.extrememachinestatus.apirest.machinestatus.controllers;

import com.extrememachinestatus.apirest.machinestatus.commons.ResponseWebApi;
import com.extrememachinestatus.apirest.machinestatus.model.ObjetosEstados;
import com.extrememachinestatus.apirest.machinestatus.services.ObjetosEstadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/objetosEstados")
public class ObjetosEstadosController {
    
    @Autowired
    private ObjetosEstadosService _objetosEstadosService;
    
    @PostMapping
    public ResponseWebApi create(@RequestBody ObjetosEstados objetoEstado) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetosEstadosService.create(objetoEstado);
        } catch (Exception e) {
            
        }
        return response;
    }

    @PostMapping("{id}")
    public ResponseWebApi update(@PathVariable("id") Long id, @RequestBody ObjetosEstados objetoEstado) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetosEstadosService.update(id, objetoEstado);
        } catch (Exception e) {
            
        }
        return response;
    }

    @GetMapping
    public ResponseWebApi getAll() {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetosEstadosService.getAll();
        } catch (Exception e) {
            
        }
        return response;
    }

    @GetMapping("{id}")
    public ResponseWebApi getById(@PathVariable("id") Long id) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetosEstadosService.getById(id);
        } catch (Exception e) {
            
        }
        return response;
    }
    
    @DeleteMapping("{id}")
    public ResponseWebApi delete(@PathVariable("id") Long id) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetosEstadosService.delete(id);
        } catch (Exception e) {
            
        }
        return response;
    }
}
