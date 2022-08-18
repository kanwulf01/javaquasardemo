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
public class RequestSatelitesDTO {
    public String _name;
    public float _distance;
    public String[] _messages = null;
    
    public RequestSatelitesDTO(String name, float distance, String[] listaMessages ) {
        this._name = name;
        this._distance = distance;
        this._messages = listaMessages;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setDistance(float _distance) {
        this._distance = _distance;
    }

    public void setMessages(String[] _messages) {
        this._messages = _messages;
    }

    public String getName() {
        return _name;
    }

    public float getDistance() {
        return _distance;
    }

    public String[] getMessages() {
        String[] messagesCastArray = new String[this._messages.length];
        for(int i = 0; i < this._messages.length; i++) {
            messagesCastArray[i] = this._messages[i];
        }
        
        return messagesCastArray;
    }
}
