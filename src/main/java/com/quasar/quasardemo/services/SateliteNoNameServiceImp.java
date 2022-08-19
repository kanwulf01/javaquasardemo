/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.services;

import com.quasar.quasardemo.DTOs.CoordenadaDTO;
import com.quasar.quasardemo.DTOs.EntityReplyDTO;
import com.quasar.quasardemo.DTOs.RequesSateliteListDTO;
import com.quasar.quasardemo.DTOs.RequestSatelitesDTO;
import com.quasar.quasardemo.DTOs.ResponseSatelitesDTO;
import com.quasar.quasardemo.DTOs.SateliteNotNameDTO;
import com.quasar.quasardemo.repository.SateliteRepositorie;
import com.quasardemo.excepcions.PostSateliteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */

@Service
public class SateliteNoNameServiceImp implements SateliteNoNameService {

    @Autowired
    private  SateliteServiceImp sateliteService;
    
    @Override
    public EntityReplyDTO add(SateliteNotNameDTO p, String NameSatelite) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
       String Message = "";
       sateliteService.satelites.put(0, NameSatelite);
       SateliteNotNameDTO data =  validateAllData(p);
       
       CoordenadaDTO coordenadas = sateliteService.GetLocation(data.getDistance());
       String[] arrayMessages = sateliteService.GetMessage(data.getMessages());
       
       for(String message : arrayMessages) {
           Message = message + Message;
       }
       return new ResponseSatelitesDTO<CoordenadaDTO>().getResponse(coordenadas, Message, "OK");
    }

    @Override
    public SateliteNotNameDTO validateAllData(SateliteNotNameDTO data) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        //Map<Integer,String> validateM = new HashMap<Integer, String>();
        
       
            //validar nulls
           
            try {
                if(data.getDistance() == 0){
                    //se saca este objeto de la lista de satelites
                    throw new PostSateliteException(""); 
                }    
            }
            catch(Exception ex) {
                throw new PostSateliteException("", ex); 
            }
            
            try {
                if(data.getMessages().length == 0){
                    //se saca este objeto de la lista de satelites
                    throw new PostSateliteException(""); 
                }    
            }
            catch(Exception ex) {
                throw new PostSateliteException("", ex); 
            }
        
        
      
        
        return new SateliteNotNameDTO(data.getDistance(), data.getMessages());
        
    }
    
}
