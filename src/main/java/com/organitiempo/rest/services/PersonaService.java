/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.organitiempo.rest.services;

import com.organitiempo.rest.models.Persona;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */

@Service
public interface PersonaService {
    List<Persona> listar();
    Persona listarId(Integer ID);
    Persona add(Persona p);
    Persona edit(Persona p);
    void delete(int id);
}
