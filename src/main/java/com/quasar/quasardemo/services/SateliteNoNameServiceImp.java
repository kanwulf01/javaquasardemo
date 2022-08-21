/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.services;

import com.quasar.quasardemo.DTOs.CoordenadaDTO;
import com.quasar.quasardemo.DTOs.EntityReplyDTO;
import com.quasar.quasardemo.DTOs.ResponseSatelitesDTO;
import com.quasar.quasardemo.DTOs.SateliteNotNameDTO;
import com.quasar.quasardemo.enums.SateliteBind;
import static com.quasar.quasardemo.services.SateliteServiceImp.validateMessage;
import com.quasardemo.excepcions.PostSateliteException;
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
       SateliteNotNameDTO data =  validateAllData(p, NameSatelite);
       
       CoordenadaDTO coordenadas = sateliteService.GetLocation(data.getDistance());
       String[] arrayMessages = validateMessage(sateliteService.GetMessage(data.getMessages()));
       
       for(String message : arrayMessages) {
           System.out.print(message);
           Message = message + " " + Message;
       }
       return new ResponseSatelitesDTO<CoordenadaDTO>().getResponse(coordenadas, Message, "OK");
    }

    @Override
    public SateliteNotNameDTO validateAllData(SateliteNotNameDTO data, String SateliteName) {
        
        
            
            //validar nulls en la data si encuentra lanzo excepciones controladas
            
            //valido si el nombre del satelite existe comparandolo con el enums de los 3 satelites validos
            SateliteBind[] names = SateliteBind.values();
            int count = 0;
            try {
                if(!SateliteName.isEmpty()){
                    //se saca este objeto de la lista de satelites
                    for(SateliteBind name:  names){
                        if(name.toString().equals(SateliteName))
                            count++;
                    }           
                    
                }
                else{
                    throw new PostSateliteException(""); 
                }
                
                if(count==0)
                    throw new PostSateliteException(""); 
            }   
            catch(Exception ex) {
                throw new PostSateliteException("", ex); 
            }
           
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
