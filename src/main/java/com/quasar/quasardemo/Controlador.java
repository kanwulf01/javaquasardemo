/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo;


import com.quasar.quasardemo.DTOs.CoordenadaDTO;
import com.quasar.quasardemo.DTOs.EntityReplyDTO;
import com.quasar.quasardemo.DTOs.RequesSateliteListDTO;
import com.quasar.quasardemo.DTOs.RequestSatelitesDTO;
import com.quasar.quasardemo.DTOs.ResponseSatelitesDTO;
import com.quasar.quasardemo.services.SateliteService;
import com.quasar.quasardemo.models.ResponseDTO;
import com.quasar.quasardemo.models.Satelite;
import static java.lang.Integer.parseInt;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javafx.util.Pair;
import org.springframework.http.ResponseEntity;
/**
 *
 * @author Lenovo
 */
@CrossOrigin(origins = "http://localhost:4200", maxAge=3600)
@RestController
@RequestMapping({"/topsecret"})
public class Controlador {
    
    @Autowired
    private SateliteService service;
    
    /*
    public Controlador(PersonaService services) {
    this.service = services;
    }
    */
    

    @PostMapping
    public ResponseEntity<EntityReplyDTO> Add(@RequestBody RequesSateliteListDTO data1) {
        
        
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
