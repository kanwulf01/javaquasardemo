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
import com.quasardemo.excepcions.PostSateliteException;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author Lenovo
 */
@RestController
@RequestMapping({"/topsecret"})
public class ControladorNivel2 {
    
    @Autowired
    private SateliteService service;
    
    /*
    public ControladorNivel2(PersonaService services) {
    this.service = services;
    }
    */
    

    @PostMapping
    @ApiParam(hidden = true) 
    public ResponseEntity<EntityReplyDTO> Add(@RequestBody RequesSateliteListDTO data1) {
        
        
        EntityReplyDTO<CoordenadaDTO> dataService = service.add(data1);
        try {
            System.out.print(dataService.getData().getX());
        System.out.print(dataService.getData().getY());
        }
        catch(Exception ex) {
            throw new  PostSateliteException(""); 
        }
        
        CoordenadaDTO resxy = new CoordenadaDTO(dataService.getData().getX(), dataService.getData().getY());
        //return new ResponseSatelitesDTO<CoordenadaDTO> { data =  }
        
        return ResponseEntity.ok().body(new ResponseSatelitesDTO<CoordenadaDTO>().getResponse(resxy, dataService.getMessage(), "OK"));
    }
    
    
    
    
    
    
    
    
}
