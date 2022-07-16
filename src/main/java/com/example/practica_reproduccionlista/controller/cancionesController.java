/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica_reproduccionlista.controller;

import com.example.practica_reproduccionlista.model.Canciones;
import com.example.practica_reproduccionlista.model.ResponseEntityCanciones;
import com.example.practica_reproduccionlista.service.CancionesServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author foraneoblack
 */
@RestController
@RequestMapping("/api/canciones")
public class cancionesController {
    
     @Autowired
     CancionesServices canciones;

    @GetMapping("/listar")
    public ResponseEntity<List<Canciones>> listar() {
        return new ResponseEntity<>(canciones.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/buscar/{titulo}")
    public ResponseEntity<Canciones> buscarCanciones(@PathVariable String titulo){
        Canciones ca = canciones.findById(titulo);
        return new ResponseEntity<>(canciones.findById(titulo), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ResponseEntityCanciones> create(@RequestBody Canciones titulo) {
       titulo.setNombre(titulo.getNombre());
        return new ResponseEntity<>(new ResponseEntityCanciones(canciones.create(titulo)), HttpStatus.OK);

    }

    @DeleteMapping("/eliminar/{titulo}")
    public ResponseEntity<Canciones> delete(@PathVariable String titulo) {
        canciones.delete(titulo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{titulo}")
    public ResponseEntity<Canciones> actualizar(@PathVariable String titulo, @RequestBody Canciones ca) {
        Canciones can = canciones.findById(titulo);
        if (can == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                can.setArtista(ca.getArtista());
                can.setAlbum(ca.getAlbum());
                can.setAnio(ca.getAnio());
                
                return new ResponseEntity<>(canciones.create(can), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }
}
