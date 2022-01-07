/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.organitiempo.rest;

import static java.lang.Integer.parseInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Lenovo
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping({"/personas"})
public class Controlador {
    
    @Autowired
    private PersonaService service;
    
    @GetMapping
    public List<Persona> listar() {
        return service.listar();
    }
    
    @PostMapping
    public Persona Add(@RequestBody Persona p) {
        return service.add(p);
    }
    
    
    @RequestMapping(path={"/{ID}"})
    @ResponseBody
    public Persona getPersona(@PathVariable("ID") Integer ID) {
        
        
        //Integer id_ = parseInt(id);
        return service.listarId(ID);
    }
}
