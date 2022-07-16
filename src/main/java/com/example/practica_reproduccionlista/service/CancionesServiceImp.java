/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica_reproduccionlista.service;

import com.example.practica_reproduccionlista.model.Canciones;
import com.example.practica_reproduccionlista.repository.CancionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author foraneoblack
 */
@Service
public class CancionesServiceImp implements CancionesServices{

    @Autowired
    CancionesRepository canciones;
    @Override
    public Canciones create(Canciones c) {
        return canciones.save(c);
    }

    @Override
    public Canciones findById(String titulo) {
        return canciones.findById(titulo).orElse(null);
    }

    @Override
    public List<Canciones> findAll() {
        return canciones.findAll();
    }

    @Override
    public void delete(String titulo) {
        canciones.deleteById(titulo);
    }
    
}
