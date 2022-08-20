/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.DTOs;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author Lenovo
 */
public class SateliteNotNameDTO {
    
    @ApiModelProperty(required = false, hidden = true)
    public float _distance;
    @ApiModelProperty(required = false, hidden = true)
    public String[] _messages = null;
    
    public SateliteNotNameDTO(float distance, String[] listaMessages ) {
        this._distance = distance;
        this._messages = listaMessages;
        
    }

    
    public void setDistance(float _distance) {
        this._distance = _distance;
    }

    public void setMessages(String[] _messages) {
        this._messages = _messages;
    }

    public float getDistance() {
        return _distance;
    }

    public String[] getMessages() {
        return this._messages;
    }
    
    
}
