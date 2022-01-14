/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.organitiempo.rest.services;

/**
 *
 * @author Lenovo
 */
import com.organitiempo.rest.repository.PersonaRepositorie;
import com.organitiempo.rest.models.Persona;
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
    private  PersonaRepositorie repository;
   
    public PersonaServiceImp(PersonaRepositorie repo) {
        
        this.repository = repo;
    }
    
     @Override
    public List<Persona> listar() {
        
        return this.repository.findAll();
    }

    @Override
    public Persona listarId(Integer ID) {
        return this.repository.getOne(ID);
        //return new Persona();
    }

    @Override
    public Persona add(Persona p) {
        return this.repository.save(p);
    }

    @Override
    public Persona edit(Persona p) {
        
        Persona pp = new Persona();
        
        pp = this.repository.getOne(p.getID());
        
        pp.setNombre(p.getNombre());
        pp.setApellidos(p.getApellidos());
        
       return this.repository.save(pp);
    }

    @Override
    public void delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Persona pp = new Persona();
        
        pp = this.repository.getOne(id);
        
        this.repository.delete(pp);
        
    }
    
}