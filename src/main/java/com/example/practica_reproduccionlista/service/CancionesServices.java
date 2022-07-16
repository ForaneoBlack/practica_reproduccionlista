/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.practica_reproduccionlista.service;

import com.example.practica_reproduccionlista.model.Canciones;
import java.util.List;

/**
 *
 * @author foraneoblack
 */
public interface CancionesServices {
    public Canciones create(Canciones c);
    public Canciones findById(String titulo);
    public List<Canciones> findAll();
    public void delete(String titulo);
}
