package org.example.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaAmericano extends JFrame {
    private JLabel lblId;
    private JLabel lblPais;
    private JLabel lblEquipo;
    private JLabel lblJugador;
    private JLabel lblNumero;
    private JLabel lblPosicion;
    private JLabel lblFoto;
    private JTextField txtId;
    private JTextField txtPais;
    private JTextField txtEquipo;
    private JTextField txtJugador;
    private JTextField txtNumero;
    private JTextField txtPosicion;
    private JTextField txtFoto;
    private JButton btnAgregar;
    private JButton btnCargar;
    private JTable tblAmericano;
    private JScrollPane scroll;
    private GridLayout layout;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JLabel imagenAme;
    private JButton btnEliminar;
    private JButton btnActualizar;

    public VentanaAmericano(String title) throws HeadlessException {
        super(title);
        this.setSize(800,900);
        layout = new GridLayout(2,2);
        this.getContentPane().setLayout(layout);

        //panel1
        panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel1.setBackground(new Color(135, 192, 222));
        lblId = new JLabel("ID: ");
        lblPais = new JLabel("PAIS: ");
        lblEquipo = new JLabel("EQUIPO: ");
        lblJugador = new JLabel("JUGADOR: ");
        lblNumero = new JLabel("NUMERO: ");
        lblPosicion = new JLabel("POSICION: ");
        lblFoto = new JLabel("FOTO: ");
        txtId = new JTextField(3);
        txtId.setText("0");
        txtId.setEnabled(false);
        txtPais = new JTextField(15);
        txtEquipo = new JTextField(15);
        txtJugador = new JTextField(30);
        txtNumero = new JTextField(3);
        txtPosicion = new JTextField(12);
        txtFoto = new JTextField(25);
        btnAgregar = new JButton("Agregar Jugador");
        panel1.add(lblId);
        panel1.add(txtId);
        panel1.add(lblPais);
        panel1.add(txtPais);
        panel1.add(lblEquipo);
        panel1.add(txtEquipo);
        panel1.add(lblJugador);
        panel1.add(txtJugador);
        panel1.add(lblNumero);
        panel1.add(txtNumero);
        panel1.add(lblPosicion);
        panel1.add(txtPosicion);
        panel1.add(lblFoto);
        panel1.add(txtFoto);
        panel1.add(btnAgregar);

        //panel2
        panel2 = new JPanel(new FlowLayout(1));
        panel2.setBackground(new Color(222, 135, 187));
        btnCargar = new JButton("Mostrar base de datos");
        panel2.add(btnCargar);
        tblAmericano = new JTable();
        scroll = new JScrollPane(tblAmericano);
        panel2.add(scroll);


        //panel3
        panel3 = new JPanel(new FlowLayout(1));
        panel3.setBackground(new Color(194, 122, 245));
        imagenAme = new JLabel("...");
        panel3.add(imagenAme);

        //panel4
        panel4 = new JPanel(new FlowLayout(1));
        panel4.setBackground(new Color(135, 222, 192));
        btnActualizar = new JButton("Actualizar datos");
        btnEliminar = new JButton("Eliminar datos");
        panel4.add(btnActualizar);
        panel4.add(btnEliminar);

        this.getContentPane().add(panel1, 0);
        this.getContentPane().add(panel2, 1);
        this.getContentPane().add(panel3, 2);
        this.getContentPane().add(panel4, 3);


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLblId() {
        return lblId;
    }

    public void setLblId(JLabel lblId) {
        this.lblId = lblId;
    }

    public JLabel getLblPais() {
        return lblPais;
    }

    public void setLblPais(JLabel lblPais) {
        this.lblPais = lblPais;
    }

    public JLabel getLblEquipo() {
        return lblEquipo;
    }

    public void setLblEquipo(JLabel lblEquipo) {
        this.lblEquipo = lblEquipo;
    }

    public JLabel getLblJugador() {
        return lblJugador;
    }

    public void setLblJugador(JLabel lblJugador) {
        this.lblJugador = lblJugador;
    }

    public JLabel getLblNumero() {
        return lblNumero;
    }

    public void setLblNumero(JLabel lblNumero) {
        this.lblNumero = lblNumero;
    }

    public JLabel getLblPosicion() {
        return lblPosicion;
    }

    public void setLblPosicion(JLabel lblPosicion) {
        this.lblPosicion = lblPosicion;
    }

    public JLabel getLblFoto() {
        return lblFoto;
    }

    public void setLblFoto(JLabel lblFoto) {
        this.lblFoto = lblFoto;
    }

    public JTextField getTxtId() {
        return txtId;
    }

    public void setTxtId(JTextField txtId) {
        this.txtId = txtId;
    }

    public JTextField getTxtPais() {
        return txtPais;
    }

    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }

    public JTextField getTxtEquipo() {
        return txtEquipo;
    }

    public void setTxtEquipo(JTextField txtEquipo) {
        this.txtEquipo = txtEquipo;
    }

    public JTextField getTxtJugador() {
        return txtJugador;
    }

    public void setTxtJugador(JTextField txtJugador) {
        this.txtJugador = txtJugador;
    }

    public JTextField getTxtNumero() {
        return txtNumero;
    }

    public void setTxtNumero(JTextField txtNumero) {
        this.txtNumero = txtNumero;
    }

    public JTextField getTxtPosicion() {
        return txtPosicion;
    }

    public void setTxtPosicion(JTextField txtPosicion) {
        this.txtPosicion = txtPosicion;
    }

    public JTextField getTxtFoto() {
        return txtFoto;
    }

    public void setTxtFoto(JTextField txtFoto) {
        this.txtFoto = txtFoto;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JButton getBtnCargar() {
        return btnCargar;
    }

    public void setBtnCargar(JButton btnCargar) {
        this.btnCargar = btnCargar;
    }

    public JTable getTblAmericano() {
        return tblAmericano;
    }

    public void setTblAmericano(JTable tblAmericano) {
        this.tblAmericano = tblAmericano;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    @Override
    public GridLayout getLayout() {
        return layout;
    }

    public void setLayout(GridLayout layout) {
        this.layout = layout;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JPanel getPanel2() {
        return panel2;
    }

    public void setPanel2(JPanel panel2) {
        this.panel2 = panel2;
    }

    public JPanel getPanel3() {
        return panel3;
    }

    public void setPanel3(JPanel panel3) {
        this.panel3 = panel3;
    }

    public JPanel getPanel4() {
        return panel4;
    }

    public void setPanel4(JPanel panel4) {
        this.panel4 = panel4;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(JButton btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public JButton getBtnActualizar() {
        return btnActualizar;
    }

    public void setBtnActualizar(JButton btnActualizar) {
        this.btnActualizar = btnActualizar;
    }

    public JLabel getImagenAme() {
        return imagenAme;
    }

    public void setImagenAme(JLabel imagenAme) {
        this.imagenAme = imagenAme;
    }

    public void limpiar(){
        txtPais.setText("");
        txtEquipo.setText("");
        txtJugador.setText("");
        txtNumero.setText("");
        txtPosicion.setText("");
        txtFoto.setText("");
    }
}
