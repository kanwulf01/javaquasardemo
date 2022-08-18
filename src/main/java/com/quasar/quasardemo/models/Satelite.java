/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quasar.quasardemo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Lenovo
 */
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Table(name="satelite")


public class Satelite  {
    
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @Column
    private String Nombre;
    @Column
    private float Distance;
    
    //@OneToMany(targetEntity = Producto.class, cascade = CascadeType.ALL)
    //@JoinColumn(name = "Fk_Persona" , referencedColumnName = "id")
    @OneToMany(mappedBy="message")
    List<Message> ListaMessage;

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setDistance(float Distance) {
        this.Distance = Distance;
    }

    public void setListaProducto(List<Message> ListaProducto) {
        this.ListaMessage = ListaMessage;
    }

    public Integer getID() {
        return ID;
    }

    public String getNombre() {
        return Nombre;
    }

    public float getDistance() {
        return Distance;
    }

    public List<Message> getListaProducto() {
        return ListaMessage;
    }
}
