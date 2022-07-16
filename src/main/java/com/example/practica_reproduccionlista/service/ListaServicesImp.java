/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica_reproduccionlista.service;

import com.example.practica_reproduccionlista.model.Lista;
import com.example.practica_reproduccionlista.repository.ListaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author foraneoblack
 */
@Service
public class ListaServicesImp implements ListaServices{

    @Autowired
    ListaRepository lista;
    
    @Override
    public Lista create(Lista l) {
       return lista.save(l);
    }

    @Override
    public Lista findById(String nombre) {
        return lista.findById(nombre).orElse(null);
    }

    @Override
    public List<Lista> findAll() {
        return lista.findAll();
    }

    @Override
    public void delete(String nombre) {
        lista.deleteById(nombre);
    }
    
}
