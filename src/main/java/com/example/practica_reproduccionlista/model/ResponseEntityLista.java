/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica_reproduccionlista.model;

/**
 *
 * @author foraneoblack
 */
public class ResponseEntityLista {
    private String nombre;
    private String descripcion;
    
    public ResponseEntityLista(Lista lista){
    this.nombre = lista.getNombre();
    this.descripcion = lista.getDescripcion();
}

    public String getNombre() {
        return nombre;
    }

  

    public String getDescripcion() {
        return descripcion;
    }

  
}
