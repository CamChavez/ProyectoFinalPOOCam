package org.example.controlador;

import org.example.modelo.FutbolAmericano;
import org.example.modelo.ModeloTablaFutbol;
import org.example.vista.VentanaAmericano;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;

public class ControladorFut extends MouseAdapter {
    private VentanaAmericano view;
    private ModeloTablaFutbol modelo;

    public ControladorFut(VentanaAmericano view) {
        this.view = view;
        modelo = new ModeloTablaFutbol();
        this.view.getTblAmericano().setModel(modelo);
        this.view.getBtnCargar().addMouseListener(this);
        this.view.getBtnAgregar().addMouseListener(this);
        this.view.getTblAmericano().addMouseListener(this);
        this.view.getBtnActualizar().addMouseListener(this);
        this.view.getBtnEliminar().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource() == this.view.getBtnCargar()){
            modelo.cargarDatos();
            this.view.getTblAmericano().setModel(modelo);
            this.view.getTblAmericano().updateUI();
        }

        if(e.getSource() == this.view.getBtnAgregar()) {
            FutbolAmericano futame = new FutbolAmericano();
            futame.setId(0);
            futame.setPais(this.view.getTxtPais().getText());
            futame.setEquipo(this.view.getTxtEquipo().getText());
            futame.setJugador(this.view.getTxtJugador().getText());
            futame.setNumero(this.view.getTxtNumero().getText());
            futame.setPosicion(this.view.getTxtPosicion().getText());
            futame.setFoto(this.view.getTxtFoto().getText());
            if (modelo.agregarInfo(futame)) {
                JOptionPane.showMessageDialog(view, "Se agrego correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.view.getTblAmericano().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo agregar a la base de datos, ojo ahi cuate",
                        "Error de insertar", JOptionPane.ERROR_MESSAGE);
            }

        }

        if (e.getSource() == view.getTblAmericano()) {
            System.out.println("Evento sobre la tabla");
            int index = this.view.getTblAmericano().getSelectedRow();
            FutbolAmericano tmp = modelo.getFutAmeAtIndex(index);
            try {
                this.view.getImagenAme().setIcon(tmp.getImagen());
                this.view.getImagenAme().setText("");
            } catch (MalformedURLException mfue) {
                System.out.println(e.toString());
                }
            }

        if (e.getSource() == this.view.getBtnActualizar()){
            int rowIndex = this.view.getTblAmericano().getSelectedRow();
            FutbolAmericano tmp = modelo.getFutAmeAtIndex(rowIndex);
            FutbolAmericano futAme = new FutbolAmericano();
            futAme.setPais(this.view.getTxtPais().getText());
            futAme.setEquipo(this.view.getTxtEquipo().getText());
            futAme.setJugador(this.view.getTxtJugador().getText());
            futAme.setNumero(this.view.getTxtNumero().getText());
            futAme.setPosicion(this.view.getTxtPosicion().getText());
            futAme.setFoto(this.view.getTxtFoto().getText());
            futAme.setId(tmp.getId());
            if (modelo.actualizarDatos(futAme)){
                JOptionPane.showMessageDialog(view, "Se modificó correctamente", "aviso", JOptionPane.INFORMATION_MESSAGE);
                modelo.cargarDatos();
                this.view.getTblAmericano().setModel(modelo);
                this.view.getTblAmericano().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo actualizar la base de datos, ojo ahi cuate",
                        "Error al actualizar", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource() == this.view.getBtnEliminar()){
            ModeloTablaFutbol extassyModel = new ModeloTablaFutbol();
            int index = this.view.getTblAmericano().getSelectedRow();
            FutbolAmericano tsss = modelo.getFutAmeAtIndex(index);
            if (extassyModel.eliminar(Integer.toString(tsss.getId()))){
                JOptionPane.showMessageDialog(view, "Se eliminó correctamente", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                modelo.cargarDatos();
                this.view.getTblAmericano().setModel(modelo);
                this.view.getTblAmericano().updateUI();
            } else {
                JOptionPane.showMessageDialog(view, "No se pudo elimnae la informacion de la base de datos, ojo ahi cuate",
                        "Error al actualizar", JOptionPane.ERROR_MESSAGE);
            }
        }

            this.view.limpiar();
        }

    }

