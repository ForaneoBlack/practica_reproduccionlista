/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.practica_reproduccionlista.repository;


import com.example.practica_reproduccionlista.model.Lista;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author foraneoblack
 */
public interface ListaRepository extends JpaRepository<Lista, String>{
    
}
