/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.services;

import com.quasar.quasardemo.DTOs.CoordenadaDTO;
import com.quasar.quasardemo.DTOs.EntityReplyDTO;
import com.quasar.quasardemo.DTOs.RequesSateliteListDTO;
import com.quasar.quasardemo.DTOs.ResponseSatelitesDTO;
import com.quasar.quasardemo.models.Satelite;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */

@Service
public interface SateliteService {
    List<Satelite> listar();
    Satelite listarId(Integer ID);
    EntityReplyDTO add(RequesSateliteListDTO p);
    Satelite edit(Satelite p);
    void delete(int id);
    CoordenadaDTO GetLocation(float dis1, float dist2, float dist3);
    List<String> GetMessage(int[] mess1, int[] mess2, int[] mess3);
    
}
