/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.DTOs;

/**
 *
 * @author Lenovo
 */
public class EntityReplyDTO<T> {
    
    
    private String Message;
    private T Data;
    

    
    public T getData() {
        return Data;
    }

    public String getMessage() {
        return Message;
    }

    

    public void setData(T Data) {
        this.Data = Data;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    
    public EntityReplyDTO(T data,String message, String status) {
        this.Data = data;
        this.Message = message;      
    }
}
