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
@RequestMapping({"/satelite"})
public class Controlador {
    
    @Autowired
    private SateliteService service;
    
    /*
    public Controlador(PersonaService services) {
    this.service = services;
    }
    */
    
    @GetMapping
    public List<Satelite> listar() {
        System.out.print("Entro a Listar!!!!!!!!!!!!!");
        return service.listar();
    }
    
    @PostMapping
    public ResponseEntity<EntityReplyDTO> Add(@RequestBody RequesSateliteListDTO data1) {
        service.add(data1);
        //recibe la data aca
        
        // Se puede validar si la distancia es un numero, si es diferente a null o a cero
        
        
        System.out.println("Llego la info");
        //System.out.println(data1.size());
        CoordenadaDTO resxy = new CoordenadaDTO(10,90.1f);
        //return new ResponseSatelitesDTO<CoordenadaDTO> { data =  }
        
        return ResponseEntity.ok().body(new ResponseSatelitesDTO<CoordenadaDTO>().getResponse(resxy, "Hola mundo", "OK"));
    }
    
    
    @PutMapping
    //@RequestMapping(path={"/editPersonas"})
    public Satelite editPersona(@RequestBody Satelite p) {
        System.out.print("hOLA mUNDO");
        return service.edit(p);
    }
    
    @RequestMapping(path={"/deletePersona/{id}"})
    @ResponseBody
    public void deletePersona(@PathVariable("id") Integer ID) {
        
        
        //Integer id_ = parseInt(id);
        service.delete(ID);
    }
    
    @RequestMapping(path={"/getPersona/{ID}"})
    @ResponseBody
    public Satelite getPersona(@PathVariable("ID") Integer ID) {
        
        System.out.println("AAAAAAAAAAAAAAAIDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAAIDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        //Integer id_ = parseInt(id);
        return service.listarId(ID);
    }
    
    //@RequestMapping(path={"/getPersonaPorNombre/{Apellidos}"})
    //@ResponseBody
    //public Persona getPersona(@PathVariable("ID") String Apellidos) {
        
        
        //Integer id_ = parseInt(id);
        //return this.service.findPersonaByFirstname(Apellidos);
    //}
    
    @RequestMapping(path={"/getPersona"})
    @ResponseBody
    public ResponseEntity<Map<String,ResponseDTO>> getReturnDouble() {
        
        //DEBOLVER 2 DATOS EN UNA UNICA RESPUESTA
        //https://stackoverflow.com/questions/38117717/what-is-the-best-way-to-return-different-types-of-responseentity-in-spring-mvc-o
        
        Map<String,ResponseDTO> response = new HashMap<String, ResponseDTO>();

        System.out.println("AAAAAAAAAAAAAAAIDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        System.out.println("AAAAAAAAAAAAAAAIDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        //Integer id_ = parseInt(id);
        ResponseDTO dto = new ResponseDTO();
        dto.setIsbn(10);
        dto.setName("Charles");
        dto.setUserId(20);
        response.put("MENSAJE", dto);
        
        return ResponseEntity.accepted().body(response);
    }
    
    
    
    
    
    
    
}
