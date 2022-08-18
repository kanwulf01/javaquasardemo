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
import com.quasar.quasardemo.DTOs.RequestSatelitesDTO;
import com.quasar.quasardemo.DTOs.ResponseSatelitesDTO;
import com.quasar.quasardemo.repository.SateliteRepositorie;
import com.quasar.quasardemo.models.Satelite;
import com.quasardemo.excepcions.PostSateliteException;
import java.util.ArrayList;
import java.util.Arrays;
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
    public EntityReplyDTO add(RequesSateliteListDTO list) {
        
        //Aca implementar el metodo que guardar la lista de satelites y sus datos 
        RequesSateliteListDTO p = new RequesSateliteListDTO();
        p = this.validateAllData(list);
        CoordenadaDTO coordenadas = null;
        String[] SanizatedMessage = null;
        String[] messageArray = null;
        String[][] listMessages = new String[p.getList().size()][p.getList().size()];
        float[] distanceArr = new float[p.getList().size()];
        String message = "";
        System.out.println("Entro al service");
        System.out.println(p.getList().size());
        int countData = 0;
        if(p.getList().size() > 0 && p.getList().size() <= 3) {
            //Envio una arreglo con datos
            System.out.println("ENTRO ACA!!");
            //1. validar las distancias 
            //||
            for(int i = 0; i < p.getList().size(); i++) {
                if(p.getList().get(i).getName() != "" && !p.getList().get(i).getName().isEmpty()) {
                    //si una distancia es igual a 0 no se puede calcular
                    //al menos una de las tres tiene que ser diferente de cero
                    
                    distanceArr[i] = p.getList().get(i).getDistance();
                    
                    //Creo una array de string y le defino el tamaño con el mismo tamaño de la lista de mensajes
                    // luego cambio el formato de la lista de mensajes a array casteandolo a un array de string y lo guardo dentro de 
                    //la variable del arreglo de strings
                    //Esto lo meto en una lista ya instanciada de arreglos de string y lo mando como parametro a la funcion GetMessages para calcular y sanitear los
                    //mensajes
                    messageArray = new String[p.getList().get(i).getMessages().length];
                    messageArray = validateMessage(p.getList().get(i).getMessages());
                    listMessages[i] = messageArray;
                    //countData ++;
                }
                
                //validar los arreglos de mensajes, si algun string no se puede leer o es diferente a las letras del abecedario se reemplaza por vacio
                
                   //p.getList().get(i).setMessages(validateMessage(p.getList().get(i).getMessages())); // mensajes leidos
                   // en este punto ya modifique cada lista de mensajes
            };
            
            //aca debo contruir el mensaje y la coordenada a partir de la lista y las distancias
            //guardar cada distancia en un arreglo de distancias
            if(distanceArr.length > 0) {
                coordenadas = this.GetLocation(distanceArr);
            }
            
            //System.out.println(coordenadas.getX() + "," + coordenadas.getY());
            
            
            
            
            // si al menos existe una distancia y un nombre de satelite se puede calcular su distancia de forma teorica
            
           
         
         //SanizatedMessage = this.GetMessage(p.getList().get(0).getMessages(), p.getList().get(1).getMessages(), p.getList().get(2).getMessages());
         SanizatedMessage = this.GetMessage(listMessages);
         
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
    public CoordenadaDTO GetLocation(float ...distances) {
        System.out.println("Distancias que entran para ser calculadas");
        for(int i = 0; i < distances.length; i++)
            System.out.println(distances[i]);
        //Aca se simula el calculo
        CoordenadaDTO coor = new CoordenadaDTO(10.89f, -90.1f);
        
        return coor;
    }

    @Override
    public  String[] GetMessage(String[] ...mess1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<String> messageBetterState = new ArrayList<String>();
        Map<Integer,Integer> validateM = new HashMap<Integer, Integer>(); // este hash contendra, la posicion del array y el numero de veces que encontro cadenas vacias
        int minorAccert = 0;
        int arrMessagePosition = 0; 
        
        for(String[] messages : mess1) {
            for(int i = 0; i < messages.length; i++) {
                if(messages[i].isEmpty())
                    minorAccert++;
            }
            
            validateM.put(arrMessagePosition, minorAccert);
            minorAccert = 0;
            arrMessagePosition++;
        }
        
        //recorro el hash y veo cual tiene el menor numero de cadenas vacias
        int valorAnterior = 0;
        int count = 0;
        int keyData = 0;
        for(Map.Entry<Integer, Integer> data : validateM.entrySet()){
             
            Integer key = data.getKey();
            Integer emptyChar = data.getValue();
            
            if(count == 0){
                //si es la primera iteracion asigno el primer valor a la variable de nombre variableAnterior para poder comprara con las siguiente siteraciones
                //cual es el valor menor, este valor menor indica el menor array de mensajes que tuvo caracteres vacios para elegir el mensaje con menos
                //caracteres vacios
                valorAnterior = emptyChar;
                count++;
                continue;
            }
            if(emptyChar<valorAnterior){
                //asigno el valor anterior si es menor el actual al anterior y la key que representa la posicion de la lista de arreglos de string 
                //que es el que tiene el array con menos caracteres vacios y por lo tanto el mensaje mas completo;
                valorAnterior = emptyChar;
                keyData = key;
            }
            
            
        }
        
        return mess1[keyData];
    }
    
    private static boolean isFloat(String cadena){
	try {
		Float.parseFloat(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    private static String[] validateMessage(String[] message){
        int count = 0;
        String[] newMessage = new String[message.length];
        for(String cadena :message) {
            
            if(cadena.isEmpty() || !cadena.matches("[a-zA-Z0-9]*") ){
                System.out.println("Entro al if porque vino algo malo en la lista de mensakes");
                newMessage[count] = "";
                count++;
                continue;
            }
            
            newMessage[count] = cadena;
            count++;
        }
        
        return newMessage;
    }
    
    
    private static RequesSateliteListDTO validateAllData(RequesSateliteListDTO data) {
        //aca debo validar que toda la informacion sea correcta
        
        //validar si el campo nombre existe y es diferente a vacio null,
        //validar qe el campo distance es diferente a null,
        //validar que listaMessages es diferente a null 
        //recorrer el arreglo que trae el objeto
        List<RequestSatelitesDTO> newCleanList = new ArrayList<RequestSatelitesDTO>();
        Map<Integer,String> validateM = new HashMap<Integer, String>();
        
        for(int i = 0; i < data.getList().size(); i++) {
            //validar nulls
            System.out.println("DISTANCIAS!!!!!");
            System.out.println(data.getList().get(i).getDistance());
            try {
                if(data.getList().get(i).getName().isEmpty()){
                    //se saca este objeto de la lista de satelites
                    validateM.put(i,"name");
                }    
            }
            catch(Exception ex) {
                throw new PostSateliteException("", ex); 
            }
            
            System.out.println(data.getList().get(i).getDistance());
            try {
                if(data.getList().get(i).getDistance() > 0){
                    //se saca este objeto de la lista de satelites
                    validateM.put(i,"distance");
                }    
            }
            catch(Exception ex) {
                throw new PostSateliteException("", ex); 
            }
            
            try {
                if(data.getList().get(i).getMessages().length == 0){
                    //se saca este objeto de la lista de satelites
                    validateM.put(i,"messages");
                }    
            }
            catch(Exception ex) {
                throw new PostSateliteException("", ex); 
            }
        }
        
        int count = 0;
        for(RequestSatelitesDTO datas : data.getList()) {
            if(validateM.containsKey(count)){
                continue;
            }
            newCleanList.add(datas);
        }
        
        System.out.println("El array limpio que va a trabajar");
        for(RequestSatelitesDTO s : newCleanList){
            System.out.println(s.getName());
        }
        return new RequesSateliteListDTO(newCleanList);
        
    }
    
    
    
}