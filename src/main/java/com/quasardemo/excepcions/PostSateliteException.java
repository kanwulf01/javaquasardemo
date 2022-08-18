/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasardemo.excepcions;

/**
 *
 * @author Lenovo
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PostSateliteException extends RuntimeException {
    
    public PostSateliteException(String message) {
        //name
        super(message);
    }

    public PostSateliteException(String message, Throwable cause) {
        super(message, cause);
    }
}
