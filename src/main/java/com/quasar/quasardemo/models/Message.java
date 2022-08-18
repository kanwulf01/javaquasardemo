/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */


    @Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name="message")

public class Message {
    @Id
    @Column(name = "id", nullable = true, updatable = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column
    private String ShortMessage;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setShortMessage(String ShortMessage) {
        this.ShortMessage = ShortMessage;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public String getShortMessage() {
        return ShortMessage;
    }

    public Message getMessage() {
        return message;
    }
    
    @ManyToOne
    @JoinColumn(name="fk_sate") 
    Message message;
}
