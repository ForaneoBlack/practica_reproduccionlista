/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.practica_reproduccionlista.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author foraneoblack
 */
@Entity
@Table(name = "canciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canciones.findAll", query = "SELECT c FROM Canciones c"),
    @NamedQuery(name = "Canciones.findByTitulo", query = "SELECT c FROM Canciones c WHERE c.titulo = :titulo"),
    @NamedQuery(name = "Canciones.findByArtista", query = "SELECT c FROM Canciones c WHERE c.artista = :artista"),
    @NamedQuery(name = "Canciones.findByAlbum", query = "SELECT c FROM Canciones c WHERE c.album = :album"),
    @NamedQuery(name = "Canciones.findByAnio", query = "SELECT c FROM Canciones c WHERE c.anio = :anio")})
public class Canciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 45)
    @Column(name = "artista")
    private String artista;
    @Size(max = 45)
    @Column(name = "album")
    private String album;
    @Size(max = 45)
    @Column(name = "anio")
    private String anio;
    @JoinColumn(name = "nombre", referencedColumnName = "nombre")
    @JsonIgnore
    @ManyToOne
    private Lista nombre;

    public Canciones() {
    }

    public Canciones(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public Lista getNombre() {
        return nombre;
    }

    public void setNombre(Lista nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titulo != null ? titulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canciones)) {
            return false;
        }
        Canciones other = (Canciones) object;
        if ((this.titulo == null && other.titulo != null) || (this.titulo != null && !this.titulo.equals(other.titulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.practica_reproduccionlista.model.Canciones[ titulo=" + titulo + " ]";
    }
    
}
