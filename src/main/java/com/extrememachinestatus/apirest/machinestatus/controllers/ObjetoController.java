package com.extrememachinestatus.apirest.machinestatus.controllers;

import com.extrememachinestatus.apirest.machinestatus.commons.ResponseWebApi;
import com.extrememachinestatus.apirest.machinestatus.model.Objeto;
import com.extrememachinestatus.apirest.machinestatus.services.ObjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/objeto")
public class ObjetoController {
    
    @Autowired
    private ObjetoService _objetoService;
    
    @PostMapping
    public ResponseWebApi create(@RequestBody Objeto objeto) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetoService.create(objeto);
        } catch (Exception e) {
            
        }
        return response;
    }

    @PostMapping("{id}")
    public ResponseWebApi update(@PathVariable("id") Long id, @RequestBody Objeto objeto) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetoService.update(id, objeto);
        } catch (Exception e) {
            
        }
        return response;
    }

    @GetMapping
    public ResponseWebApi getAll() {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetoService.getAll();
        } catch (Exception e) {
            
        }
        return response;
    }

    @GetMapping("{id}")
    public ResponseWebApi getById(@PathVariable("id") Long id) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetoService.getById(id);
        } catch (Exception e) {
            
        }
        return response;
    }
    
    @DeleteMapping("{id}")
    public ResponseWebApi delete(@PathVariable("id") Long id) {
        ResponseWebApi response = new ResponseWebApi();
        try {
            response = _objetoService.delete(id);
        } catch (Exception e) {
            
        }
        return response;
    }
}
