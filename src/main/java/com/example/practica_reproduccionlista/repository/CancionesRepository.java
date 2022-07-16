/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.practica_reproduccionlista.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.practica_reproduccionlista.model.Canciones;
/**
 *
 * @author foraneoblack
 */
public interface CancionesRepository extends JpaRepository<Canciones, String>{
    
}
