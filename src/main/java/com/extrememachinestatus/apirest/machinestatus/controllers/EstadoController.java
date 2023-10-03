package com.extrememachinestatus.apirest.machinestatus.controllers;

import com.extrememachinestatus.apirest.machinestatus.commons.ResponseWebApi;
import com.extrememachinestatus.apirest.machinestatus.model.Estado;
import com.extrememachinestatus.apirest.machinestatus.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/estado")
public class EstadoController {
    
    @Autowired
    private EstadoService _estadoService;
    
    @PostMapping
    public ResponseWebApi create(@RequestBody Estado estado) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _estadoService.create(estado);
        } catch (Exception e) {
            
        }
        return response;
    }

    @PostMapping("{id}")
    public ResponseWebApi update(@PathVariable("id") Long id, @RequestBody Estado estado) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _estadoService.update(id, estado);
        } catch (Exception e) {
            
        }
        return response;
    }

    @GetMapping
    public ResponseWebApi getAll() {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _estadoService.getAll();
        } catch (Exception e) {
            
        }
        return response;
    }

    @GetMapping("{id}")
    public ResponseWebApi getById(@PathVariable("id") Long id) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _estadoService.getById(id);
        } catch (Exception e) {
            
        }
        return response;
    }
    
    @DeleteMapping("{id}")
    public ResponseWebApi delete(@PathVariable("id") Long id) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _estadoService.delete(id);
        } catch (Exception e) {
            
        }
        return response;
    }
}
