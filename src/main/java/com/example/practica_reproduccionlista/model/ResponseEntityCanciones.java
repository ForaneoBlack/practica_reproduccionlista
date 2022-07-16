/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica_reproduccionlista.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author foraneoblack
 */
public class ResponseEntityCanciones {
    private String titulo;
    private String artista;
    private String album;
    private String anio;
    
    
    @ManyToOne
    private Lista nombre;
    
    public ResponseEntityCanciones(Canciones can){
        this.titulo = can.getTitulo();
        this.artista = can.getArtista();
        this.album = can.getAlbum();
        this.anio = can.getAnio();
        this.nombre = can.getNombre();
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public String getAlbum() {
        return album;
    }

    public String getAnio() {
        return anio;
    }

    public Lista getNombre() {
        return nombre;
    }
    
}
