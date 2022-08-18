/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.quasar.quasardemo.services;

/**
 *
 * @author Lenovo
 */
import com.quasar.quasardemo.DTOs.CoordenadaDTO;
import com.quasar.quasardemo.DTOs.EntityReplyDTO;
import com.quasar.quasardemo.DTOs.RequesSateliteListDTO;
import com.quasar.quasardemo.DTOs.ResponseSatelitesDTO;
import com.quasar.quasardemo.repository.SateliteRepositorie;
import com.quasar.quasardemo.models.Satelite;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Lenovo
 */

@Service

public class SateliteServiceImp implements SateliteService {
    
    @Autowired
    private  SateliteRepositorie repository;
   
    public SateliteServiceImp(SateliteRepositorie repo) {
        
        this.repository = repo;
    }
    
     @Override
    public List<Satelite> listar() {
        
        return this.repository.findAll();
    }

    @Override
    public Satelite listarId(Integer ID) {
        
        System.out.println("LLEGO AL SERVICE IMP");
        return this.repository.getOne(ID);
        //return new Persona();
    }

    @Override
    public EntityReplyDTO add(RequesSateliteListDTO p) {
        
        //Aca implementar el metodo que guardar la lista de satelites y sus datos 
        
        Map<String,Float> response = new HashMap<String, Float>();
        System.out.println("Entro al service");
        System.out.println(p.getList().size());
        int countData = 0;
        if(p.getList().size() > 0) {
            //Envio una arreglo con datos
            System.out.println("ENTRO ACA!!");
            //1. validar las distancias 
            for(int i = 0; i < p.getList().size(); i++) {
                if(p.getList().get(i).getDistance() != 0 && p.getList().get(i).getName() != "" && !p.getList().get(i).getName().isEmpty()) {
                    //si una distancia es igual a 0 no se puede calcular
                    //al menos una de las tres tiene que ser diferente de cero
                    countData ++;
                }
                
                //validar los arreglos de mensajes, si algun string no se puede leer o es diferente a las letras del abecedario se reemplaza por vacio
                
                   p.getList().get(i).setMessages(validateMessage(p.getList().get(i).getMessages()));
                
            };
            
            
            
            
            
            // si al menos existe una distancia y un nombre de satelite se puede calcular su distancia de forma teorica
            
         for(String cadena: p.getList().get(0).getMessages()){
             System.out.println(cadena);
         }   
            
        }
        
        CoordenadaDTO resxy = new CoordenadaDTO(10,90.1f);
        
        return new ResponseSatelitesDTO<CoordenadaDTO>().getResponse(resxy, "Hola mundo", "OK");
        
        //return new ResponseSatelitesDTO<>
        //return this.repository.save(p);
    }

    @Override
    public Satelite edit(Satelite p) {
        
        Satelite pp = new Satelite();
        
        pp = this.repository.getOne(p.getID());
        
        //pp.setNombre(p.getNombre());
        //pp.setApellidos(p.getApellidos());
        
       return this.repository.save(pp);
    }

    @Override
    public void delete(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        Satelite pp = new Satelite();
        
        pp = this.repository.getOne(id);
        
        this.repository.delete(pp);
        
    }

    //@Override
    //public Persona findPersonaByFirstname(String Apellidos) {
      //  return this.repository.findPersonaByFirstname(Apellidos);
   // }

    @Override
    public CoordenadaDTO GetLocation(float dis1, float dist2, float dist3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> GetMessage(int[] mess1, int[] mess2, int[] mess3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static boolean isFloat(String cadena){
	try {
		Float.parseFloat(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    private static List<String> validateMessage(List<String> message){
        int count = 0;
        List<String> newMessage = new ArrayList<String>();
        for(String cadena :message) {
            
            if(cadena.isEmpty() || !cadena.matches("[a-zA-Z0-9]*") ){
                System.out.println("Entro al if porque vino algo malo en la lista de mensakes");
                newMessage.add("");
                count++;
                continue;
            }
            
            newMessage.add(cadena);
            count++;
        }
        
        return newMessage;
    }
    
    
    
}