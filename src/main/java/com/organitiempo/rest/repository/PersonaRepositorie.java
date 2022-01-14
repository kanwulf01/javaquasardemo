/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.organitiempo.rest.repository;

/**
 *
 * @author Lenovo
 */
import com.organitiempo.rest.models.Persona;
import com.organitiempo.rest.models.Persona;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */


@Repository

public interface PersonaRepositorie extends JpaRepository<Persona, Integer> {
        List<Persona> findAll();
        //Persona findOne(Integer ID);
        Persona getOne(Integer ID);
        Persona save(Persona p);
        void delete(Persona p);
        
        
}
