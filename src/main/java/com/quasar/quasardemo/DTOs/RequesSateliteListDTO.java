/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.DTOs;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public class RequesSateliteListDTO {
    
    public List<RequestSatelitesDTO> satelites;
    
    public RequesSateliteListDTO(){}
    
    public RequesSateliteListDTO(List<RequestSatelitesDTO> list) {
        this.satelites = list;
    }

    public List<RequestSatelitesDTO> getList() {
        return satelites;
    }

    public void setList(List<RequestSatelitesDTO> _list) {
        this.satelites = _list;
    }
    
    
    
    
}
