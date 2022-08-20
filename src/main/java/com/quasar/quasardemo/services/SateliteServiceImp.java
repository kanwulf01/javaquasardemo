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
import com.quasar.quasardemo.DTOs.SateliteNotNameDTO;
import com.quasar.quasardemo.constants.Constants;
import com.quasar.quasardemo.enums.SateliteBind;
import com.quasar.quasardemo.repository.SateliteRepositorie;
import com.quasar.quasardemo.models.Satelite;
import com.quasardemo.excepcions.PostSateliteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
    private String SateliteName;
    public Map<Integer,String> satelites = new HashMap<Integer, String>();
   
    public SateliteServiceImp(SateliteRepositorie repo) {
        
        this.repository = repo;
    }
    
    

    @Override
    public EntityReplyDTO add(RequesSateliteListDTO list) {
        
        //Aca implementar el metodo que guardar la lista de satelites y sus datos 
        RequesSateliteListDTO p = new RequesSateliteListDTO();
        
        p = this.validateAllData(list);
        CoordenadaDTO coordenadas = null;
        String[] SanizatedMessage = null;
        String[] messageArray = null;
        String[][] listMessages = new String[p.getList().size()][p.getList().size()]; //declaro la matriz que envio a GetMesages segun el tamaño del array de objetos que llega
        float[] distanceArr = new float[p.getList().size()];
        String message = "";
        int countData = 0;
        if(p.getList().size() > 0 && p.getList().size() <= 3) { //valido que sea un arreglo de no mas de 3 objetos y mayor a 0 elementos

            for(int i = 0; i < p.getList().size(); i++) {//recorro el arreglo de elementos que me llega
                if(p.getList().get(i).getName() != "" && !p.getList().get(i).getName().isEmpty()) {// es una validacion con poco peso
                                   
                    distanceArr[i] = p.getList().get(i).getDistance();//guardo cada distancia 
                    satelites.put(i, p.getList().get(i).getName());//guardo la posicion y el nombre de cada satelite al que le mandan la data
                   
                    messageArray = new String[p.getList().get(i).getMessages().length];//defino el nuevo array de mensajes de cada objeto que contendra solo caracteres validos 
                    // o reemplazados por vacio
                    
                    messageArray = validateMessage(p.getList().get(i).getMessages());//aca retorno el arreglo saneado por cada objeto 
                    listMessages[i] = messageArray; //aca lo guardo entro de la matriz de arreglos de string para pasarlo como param a GetMessage
                    //countData ++;
                }
                
                //validar los arreglos de mensajes, si algun string no se puede leer o es diferente a las letras del abecedario se reemplaza por vacio
                
                 
            };
            
            //aca debo contruir el mensaje y la coordenada a partir de la lista y las distancias
            //guardar cada distancia en un arreglo de distancias
            if(distanceArr.length > 0) {//valido que el arreglo de distancias sea mayor a 0
                coordenadas = this.GetLocation(distanceArr);//retorno la coordenada
            }
                        
            // si al menos existe una distancia y un nombre de satelite se puede calcular su distancia de forma teorica
            
           
         
         SanizatedMessage = this.GetMessage(listMessages);//retorno el mensaje ya "arreglado"
         
         for(String cadena: SanizatedMessage){//construyo el mensaje
             message = message + " " + cadena;
         } 
        }
        else {
            message = "false";
            
        }
        
        return new ResponseSatelitesDTO<CoordenadaDTO>().getResponse(coordenadas, message, "OK");//respondo al controlador con las coordenadas y el mensaje saneado
        
        //return new ResponseSatelitesDTO<>
        //return this.repository.save(p);
    }

    @Override
    public CoordenadaDTO GetLocation(float ...distances) {
        for(int i = 0; i < distances.length; i++)
            System.out.println(distances[i]);
        //Aca se simula el calculo
        //tengo un hash con la posicion del arrgelo que contiene cada objeto por nombre del satelite: variable satelites Map<position del arreglo, Nombre del satelite>
        //tengo un enum con los nombres de los 3 satelites
        //tengo una clase constantes con las 3 coordenadas de cada satelite
        
        //Para terminos practicos genero las coordenadas de forma aleatoria
        Random rand = new Random();
        float randomNum1 = 1.1f + ( 100.10f - 1.1f ) * rand.nextFloat();
        float randomNum2 = 1.1f + ( 100.10f - 1.1f ) * rand.nextFloat();
        CoordenadaDTO coor = new CoordenadaDTO(randomNum1, randomNum2);
        
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
                if(messages[i].isEmpty()){
                    minorAccert++;
                }
                    
            }
            
            validateM.put(arrMessagePosition, minorAccert);
            minorAccert = 0;
            arrMessagePosition++;
        }
        List<Integer> cleanMessages = new ArrayList<Integer>();
        //recorro el hash y veo cual tiene el menor numero de cadenas vacias
        int valorAnterior = 0;
        int count = 0;
        int keyData = 0;
        int count2 = 0;
        int equals = 0;
        for(Map.Entry<Integer, Integer> data : validateM.entrySet()){
             
            Integer key = data.getKey();
            Integer emptyChar = data.getValue();
            
            if(emptyChar == 0) {
                cleanMessages.add(key);
               
            }
            if(count == 0){
                //si es la primera iteracion asigno el primer valor a la variable de nombre variableAnterior para poder compararla con las siguientes iteraciones
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
            }else {
                //que pasa si tienen los mismos caracteres corruptos
                //agarre la posicion key
                equals++;
            }
            
            
            
        }
        
       
       
            //Encontro mas de 2 mensajes limpios sin errores
            //agarre el de la posicion mas grande
            int mayorSize = 0;
            for(int i = 0; i < cleanMessages.size(); i++){
                
                    System.out.println(cleanMessages.get(i));
                    if(mess1[cleanMessages.get(i)].length > mayorSize){
                        mayorSize = mess1[cleanMessages.get(i)].length;
                        keyData = cleanMessages.get(i);
                    }
            }
            if(equals == mess1.length) {
                int mayorSize2 = 0;
                for(int i = 0; i < equals; i++) {
                    if(mess1[cleanMessages.get(i)].length > mayorSize){
                        mayorSize = mess1[cleanMessages.get(i)].length;
                        keyData = cleanMessages.get(i);
                    }
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
    
    public static String[] validateMessage(String[] message){
        //Aca valido el string que viene en el arreglo, uso una regex para validar que sean solo caracteres validos o numeros
        int count = 0;
        String[] newMessage = new String[message.length];
        for(String cadena :message) {
            
            if(cadena.isEmpty() || !cadena.matches("[a-zA-Z0-9]*") ){
                newMessage[count] = "";
                count++;
                continue;
            }
            
            newMessage[count] = cadena;
            count++;
        }
        
        return newMessage;
    }
    
    @Override
    public RequesSateliteListDTO validateAllData(RequesSateliteListDTO data) {
        //aca debo validar que toda la informacion sea correcta
        
        //validar si el campo nombre existe y es diferente a vacio null,
        //validar qe el campo distance es diferente a null,
        //validar que listaMessages es diferente a null 
        //recorrer el arreglo que trae el objeto
        
        
        //El hash me ayuda a agarrar la posicion de los objetos que tienen algun dato invalido
        //para despues leer este mismo arreglo de objetos y pasarlo a un nuevo dejando por fuera los indices que estan en el hash
        //es decir uso las posicion como ids de cada objeto dentreo del arreglo que llega a este metodo
        List<RequestSatelitesDTO> newCleanList = new ArrayList<RequestSatelitesDTO>();
        Map<Integer,String> validateM = new HashMap<Integer, String>();
        
        SateliteBind[] names = SateliteBind.values();
        int itera = 0;
                  
                    
        
        for(int i = 0; i < data.getList().size(); i++) {
            //validar nulls
            
            try {
                if(data.getList().get(i).getName().isEmpty()){
                    //se saca este objeto de la lista de satelites
                    validateM.put(i,"name");
                }else {
                    for(SateliteBind name:  names){
                        if(name.toString().equals(data.getList().get(i).getName()))
                            itera++;            
                    }
                    
                    if(itera==0){
                        validateM.put(i,"name");
                    }
                     itera = 0;   
                }   
            }
            catch(Exception ex) {
                throw new PostSateliteException("", ex); 
            }
            
          
            try {
                if(data.getList().get(i).getDistance() == 0){
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
        
        
        //Aca saco a los que estan "marcados" segun su posicion por el hashMap y no los meto al nuevo arreglo que va a retornar
        int count = 0;
        for(RequestSatelitesDTO datas : data.getList()) {
            if(validateM.containsKey(count)){
                count++;
                continue;
            }
            newCleanList.add(datas);
            count++;
        }
        
    
        return new RequesSateliteListDTO(newCleanList);//retorno la nueva lista con los objetos validados
        
    }

    
    
}