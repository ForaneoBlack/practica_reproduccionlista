/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.practica_reproduccionlista.service;

import com.example.practica_reproduccionlista.model.Lista;
import java.util.List;

/**
 *
 * @author foraneoblack
 */
public interface ListaServices {
    public Lista create(Lista l);
    public Lista findById(String nombre);
    public List<Lista> findAll();
    public void delete(String nombre);
}
