/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo;

import com.quasar.quasardemo.DTOs.CoordenadaDTO;
import com.quasar.quasardemo.DTOs.EntityReplyDTO;
import com.quasar.quasardemo.DTOs.RequesSateliteListDTO;
import com.quasar.quasardemo.DTOs.ResponseSatelitesDTO;
import com.quasar.quasardemo.services.SateliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lenovo
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping({"/topsecret_split"})
public class TopSecretSplitControllador {
    
    
    @Autowired
    private SateliteService service;
    
    
    @RequestMapping(path={"/{satelite_name}"})
    @PostMapping
    public ResponseEntity<EntityReplyDTO> Add(@RequestBody RequesSateliteListDTO data1, @PathVariable("satelite_name") String satelite_name) {
        
        
        EntityReplyDTO<CoordenadaDTO> dataService = service.add(data1);
        
        System.out.println("coordenadas repsuesta de service");
        System.out.println(dataService.getData().getX());
        System.out.println(dataService.getData().getY());
        System.out.println(dataService.getMessage());
        //recibe la data aca
        
        // Se puede validar si la distancia es un numero, si es diferente a null o a cero
        
        
        System.out.println("Llego la info");
        //System.out.println(data1.size());
        CoordenadaDTO resxy = new CoordenadaDTO(10,90.1f);
        //return new ResponseSatelitesDTO<CoordenadaDTO> { data =  }
        
        return ResponseEntity.ok().body(new ResponseSatelitesDTO<CoordenadaDTO>().getResponse(resxy, dataService.getMessage(), "OK"));
    }
}
