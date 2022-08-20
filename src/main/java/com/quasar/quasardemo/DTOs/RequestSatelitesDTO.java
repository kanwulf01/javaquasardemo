/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.DTOs;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class RequestSatelitesDTO {
    
    @ApiModelProperty(required = false, hidden = true)
    public String name;
    @ApiModelProperty(required = false, hidden = true)
    public float distance;
    @ApiModelProperty(required = false, hidden = true)
    public String[] messages = null;
    
    public RequestSatelitesDTO(String name, float distance, String[] listaMessages ) {
        this.name = name;
        this.distance = distance;
        this.messages = listaMessages;
    }

    public void setName(String _name) {
        this.name = _name;
    }

    public void setDistance(float _distance) {
        this.distance = _distance;
    }

    public void setMessages(String[] _messages) {
        this.messages = _messages;
    }

    public String getName() {
        return name;
    }

    public float getDistance() {
        return distance;
    }

    public String[] getMessages() {
        String[] messagesCastArray = new String[this.messages.length];
        for(int i = 0; i < this.messages.length; i++) {
            messagesCastArray[i] = this.messages[i];
        }
        
        return messagesCastArray;
    }
}
