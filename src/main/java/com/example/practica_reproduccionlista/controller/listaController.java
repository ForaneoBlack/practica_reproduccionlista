/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica_reproduccionlista.controller;

import com.example.practica_reproduccionlista.model.Lista;
import com.example.practica_reproduccionlista.model.ResponseEntityLista;
import com.example.practica_reproduccionlista.repository.ListaRepository;
import com.example.practica_reproduccionlista.service.ListaServices;
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
@RequestMapping("/api/lista")
public class listaController {

    @Autowired
    ListaServices lista;

    @GetMapping("/mostrar")
    public ResponseEntity<List<Lista>> listar() {
        
        if(lista.findAll().size() == 0){
            return new ResponseEntity<>(lista.findAll(),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(lista.findAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{nombre}")
    public ResponseEntity<Lista> buscarLista(@PathVariable String nombre) {
        Lista ls = lista.findById(nombre);
        
        return new ResponseEntity<>(lista.findById(nombre), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<ResponseEntityLista> create(@RequestBody Lista nombre) {
        if(nombre.getNombre() == null){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            try {
                return new ResponseEntity<>(new ResponseEntityLista(lista.create(nombre)), HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

    }

    @DeleteMapping("/eliminar/{nombre}")
    public ResponseEntity<Lista> delete(@PathVariable String nombre) {
        lista.delete(nombre);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{nombre}")
    public ResponseEntity<ResponseEntityLista> actualizar(@PathVariable String nombre, @RequestBody Lista ls) {
        Lista lt = lista.findById(nombre);
        if (lt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
               
                lt.setDescripcion(lt.getDescripcion());

                return new ResponseEntity<>(new ResponseEntityLista(lista.create(ls)), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }

    }

}
