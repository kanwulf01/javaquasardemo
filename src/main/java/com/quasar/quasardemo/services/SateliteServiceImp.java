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
        
        CoordenadaDTO coordenadas = null;
        List<String> SanizatedMessage = null;
        String message = "";
        System.out.println("Entro al service");
        System.out.println(p.getList().size());
        int countData = 0;
        if(p.getList().size() > 0 && p.getList().size() <= 3) {
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
                   // en este punto ya modifique cada lista de mensajes
            };
            
            //aca debo contruir el mensaje y la coordenada a partir de la lista y las distancias
            
            if(countData > 0) {
                coordenadas = this.GetLocation(p.getList().get(0).getDistance(), p.getList().get(1).getDistance(), p.getList().get(2).getDistance());
            }
            
            System.out.println(coordenadas.getX() + "," + coordenadas.getY());
            
            
            
            
            // si al menos existe una distancia y un nombre de satelite se puede calcular su distancia de forma teorica
            
           
         
         SanizatedMessage = this.GetMessage(p.getList().get(0).getMessages(), p.getList().get(1).getMessages(), p.getList().get(2).getMessages());
         
         for(String cadena: SanizatedMessage){
             System.out.println(cadena);
             message = message + " " + cadena;
         } 
        }
        else {
            message = "false";
            
        }
        
        System.out.println("MENSAJE CONCATENADO COMPLETO");
        System.out.println(message);
        
        
        return new ResponseSatelitesDTO<CoordenadaDTO>().getResponse(coordenadas, message, "OK");
        
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
        
        //Aca se simula el calculo
        CoordenadaDTO coor = new CoordenadaDTO(10.89f, -90.1f);
        
        return coor;
    }

    @Override
    public  List<String> GetMessage(List<String> mess1, List<String> mess2, List<String> mess3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<String> messageBetterState = new ArrayList<String>();
        int minorAccert1 = 0;
        int minorAccert2 = 0;
        int minorAccert3 = 0;
        
        for(String cadena : mess1) {
            if(cadena.isEmpty()) {
                minorAccert1++;
            }
        }
        
        for(String cadena : mess2) {
            if(cadena.isEmpty()) {
                minorAccert2++;
            }
        }
        
        for(String cadena : mess3) {
            if(cadena.isEmpty()) {
                minorAccert3++;
            }
        }
        
        if(minorAccert1 <= minorAccert2 && minorAccert1 <= minorAccert3)
            messageBetterState = mess1;
        if(minorAccert2 <= minorAccert1 && minorAccert2 <= minorAccert3)
            messageBetterState = mess2;
        if(minorAccert3 <= minorAccert1 && minorAccert3 <= minorAccert2)
            messageBetterState = mess3;
        
        
        return messageBetterState;
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