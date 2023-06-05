package org.example;

import org.example.controlador.ControladorFut;
import org.example.modelo.FutbolAmericano;
import org.example.persistencia.AmericanoDAO;
import org.example.vista.VentanaAmericano;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        VentanaAmericano view =new VentanaAmericano("FUTBOL AMERICANO");
        ControladorFut controlador = new ControladorFut(view);

    }
}