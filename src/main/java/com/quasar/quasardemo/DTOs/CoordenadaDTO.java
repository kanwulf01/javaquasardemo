/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.DTOs;

/**
 *
 * @author Lenovo
 */
public class CoordenadaDTO {
    public float x;
    public float y;
    
    
    public CoordenadaDTO(float x1, float y1) {
        this.x = x1;
        this.y = y1;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
    
    
}
