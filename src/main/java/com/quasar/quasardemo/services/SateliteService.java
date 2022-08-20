/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.services;

import com.quasar.quasardemo.DTOs.CoordenadaDTO;
import com.quasar.quasardemo.DTOs.EntityReplyDTO;
import com.quasar.quasardemo.DTOs.RequesSateliteListDTO;
import com.quasar.quasardemo.DTOs.ResponseSatelitesDTO;
import com.quasar.quasardemo.DTOs.SateliteNotNameDTO;
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
    
    EntityReplyDTO add(RequesSateliteListDTO p );
   
    CoordenadaDTO GetLocation(float ...distance);
    String[] GetMessage(String[] ...mess1);
    RequesSateliteListDTO validateAllData(RequesSateliteListDTO data);
    
}
