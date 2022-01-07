/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.organitiempo.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */

@Service

public class PersonaServiceImp implements PersonaService {
    @Autowired
   
    private PersonaRepositorie repository;
    
    
    public PersonaServiceImp(PersonaRepositorie repo) {
        
        this.repository = repo;
    }
    
     @Override
    public List<Persona> listar() {
        
        return this.repository.findAll();
    }

    @Override
    public Persona listarId(Integer ID) {
        return this.repository.findById(ID);
        //return new Persona();
    }

    @Override
    public Persona add(Persona p) {
        return this.repository.save(p);
    }

    @Override
    public Persona edit(Persona p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Persona delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
