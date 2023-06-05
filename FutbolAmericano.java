package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class FutbolAmericano {
    private int id;
    private String pais;
    private String equipo;
    private String jugador;
    private String numero;
    private String posicion;
    private String foto;

    public FutbolAmericano() {
    }

    public FutbolAmericano(int id, String pais, String equipo, String jugador, String numero, String posicion, String foto) {
        this.id = id;
        this.pais = pais;
        this.equipo = equipo;
        this.jugador = jugador;
        this.numero = numero;
        this.posicion = posicion;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "FutbolAmericano{" +
                "id=" + id +
                ", pais='" + pais + '\'' +
                ", equipo='" + equipo + '\'' +
                ", jugador='" + jugador + '\'' +
                ", numero='" + numero + '\'' +
                ", posicion='" + posicion + '\'' +
                ", foto='" + foto + '\'' +
                '}';
    }
    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImage = new URL(this.foto);
        return new ImageIcon(urlImage);
    }
}