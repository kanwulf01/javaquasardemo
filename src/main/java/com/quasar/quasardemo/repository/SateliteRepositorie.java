/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.repository;

/**
 *
 * @author Lenovo
 */

import com.quasar.quasardemo.models.Satelite;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Lenovo
 */


@Repository

public interface SateliteRepositorie extends JpaRepository<Satelite, Integer> {
        @Override
        //List<Persona> findAll();
        //Persona findOne(Integer ID);
        Satelite getOne(Integer ID);
        Satelite save(Satelite s);

    /**
     *
     * @param p
     */
    @Override
        void delete(Satelite s);
        
        
        //@Query("select u from Persona u where u.Apellidos = :Apellidos")
        //Persona findPersonaByFirstname(@Param("Apellidos") String Apellidos);
        
        
}
