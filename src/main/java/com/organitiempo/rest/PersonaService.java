/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.organitiempo.rest;
import java.util.List;
/**
 *
 * @author Lenovo
 */
public interface PersonaService {
    List<Persona> listar();
    Persona listarId(int id);
    Persona add(Persona p);
    Persona edit(Persona p);
    Persona delete(int id);
}
