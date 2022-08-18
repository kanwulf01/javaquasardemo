/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.DTOs;

/**
 *
 * @author Lenovo
 */
public class ResponseSatelitesDTO<T> {
    
     /**
     *
     * @param type
     * @param message
     * @param status
     * @return
     */
    public EntityReplyDTO getResponse(T type, String message, String status) {
        return new EntityReplyDTO<T>(type,message, status);
    }
}
