/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.organitiempo.rest;
import java.util.List;

import org.springframework.data.repository.Repository;

/**
 *
 * @author Lenovo
 */
public interface PersonaRepositorie extends Repository<Persona, Integer> {
        List<Persona> findAll();
        //Persona findOne(Integer ID);
        Persona findById(Integer ID);
        Persona save(Persona p);
        void delete(Persona p);
        
        
}
