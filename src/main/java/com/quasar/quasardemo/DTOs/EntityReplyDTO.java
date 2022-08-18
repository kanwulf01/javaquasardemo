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
    
    
    private String Status;
    private T Data;
    private String Message;

    public String getStatus() {
        return Status;
    }

    public T getData() {
        return Data;
    }

    public String getMessage() {
        return Message;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setData(T Data) {
        this.Data = Data;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
    
    public EntityReplyDTO(T data,String message, String status) {
        
        this.Status = status;
        this.Message = message;
        this.Data = data;
        
    }
}
