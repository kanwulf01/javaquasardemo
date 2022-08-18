/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.models;

/**
 *
 * @author Lenovo
 */
public class ResponseDTO {
    
    private int isbn;
    private int  userId;
    private String name;

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIsbn() {
        return isbn;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }
    
}
