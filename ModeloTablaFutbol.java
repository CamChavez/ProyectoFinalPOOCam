package org.example.modelo;

import org.example.persistencia.AmericanoDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloTablaFutbol implements TableModel {
    public static final int COLUMNS = 7;
    private ArrayList<FutbolAmericano> datos;
    private AmericanoDAO amedao;

    public ModeloTablaFutbol() {
        amedao = new AmericanoDAO();
        datos = new ArrayList<>();
    }

    public ModeloTablaFutbol(ArrayList<FutbolAmericano> datos) {
        this.datos = datos;
        amedao = new AmericanoDAO();
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNS;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "id";
            case 1:
                return "pais";
            case 2:
                return "equipo";
            case 3:
                return "jugador";
            case 4:
                return "numero";
            case 5:
                return "posicion";
            case 6:
                return "foto";

        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return String.class;
            case 4:
                return String.class;
            case 5:
                return String.class;
            case 6:
                return String.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FutbolAmericano tmp = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tmp.getId();
            case 1:
                return tmp.getPais();
            case 2:
                return tmp.getEquipo();
            case 3:
                return tmp.getJugador();
            case 4:
                return tmp.getNumero();
            case 5:
                return tmp.getPosicion();
            case 6:
                return tmp.getFoto();

        }
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                //datos.get(rowIndex).setId(0);
                break;
            case 1:
                datos.get(rowIndex).setPais((String) aValue);
                break;
            case 2:
                datos.get(rowIndex).setEquipo((String) aValue);
                break;
            case 3:
                datos.get(rowIndex).setJugador((String) aValue);
                break;
            case 4:
                datos.get(rowIndex).setNumero((String) aValue);
                break;
            case 5:
                datos.get(rowIndex).setPosicion((String) aValue);
                break;
            case 6:
                datos.get(rowIndex).setFoto((String) aValue);
                break;
            default:
                System.out.println("no se agrego nada");
        }

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    public void cargarDatos() {
        try {
            datos = amedao.obtenerTodo();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public boolean agregarInfo(FutbolAmericano FutAme) {
        boolean resultado = false;
        try {
            if (amedao.insertar(FutAme)) {
                datos.add(FutAme);
                resultado = true;
            } else {
                resultado = false;
            }
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
        return resultado;
    }
    public  FutbolAmericano getFutAmeAtIndex(int idx){
        return datos.get(idx);

    }
    public boolean actualizarDatos  (FutbolAmericano futAmeActua){
        boolean resultado = false;
        try {
            if (amedao.update(futAmeActua)) {
                datos.add(futAmeActua);
                resultado = true;
            } else {
                resultado = false;
            }
        }catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
            return resultado;
        }
        public  boolean eliminar (String id){
        boolean resultado = false;
        try{
            if(amedao.delete(id)){
                resultado = true;
            }else{
                resultado = false;
            }
        }catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
            return resultado;
            }
        }

