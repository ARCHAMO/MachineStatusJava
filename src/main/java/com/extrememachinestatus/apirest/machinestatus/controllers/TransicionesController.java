package com.extrememachinestatus.apirest.machinestatus.controllers;

import com.extrememachinestatus.apirest.machinestatus.commons.ResponseWebApi;
import com.extrememachinestatus.apirest.machinestatus.model.Transiciones;
import com.extrememachinestatus.apirest.machinestatus.services.TransicionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/transiciones")
public class TransicionesController {
    
    @Autowired
    private TransicionesService _transicionesService;
    
    @PostMapping
    public ResponseWebApi create(@RequestBody Transiciones transicion) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _transicionesService.create(transicion);
        } catch (Exception e) {
            
        }
        return response;
    }

    @PostMapping("{id}")
    public ResponseWebApi update(@PathVariable("id") Long id, @RequestBody Transiciones transicion) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _transicionesService.update(id, transicion);
        } catch (Exception e) {
            
        }
        return response;
    }

    @GetMapping
    public ResponseWebApi getAll() {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _transicionesService.getAll();
        } catch (Exception e) {
            
        }
        return response;
    }

    @GetMapping("{id}")
    public ResponseWebApi getById(@PathVariable("id") Long id) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _transicionesService.getById(id);
        } catch (Exception e) {
            
        }
        return response;
    }
    
    @DeleteMapping("{id}")
    public ResponseWebApi delete(@PathVariable("id") Long id) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _transicionesService.delete(id);
        } catch (Exception e) {
            
        }
        return response;
    }
}
