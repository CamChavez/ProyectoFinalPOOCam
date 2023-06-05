package org.example.persistencia;

import org.example.modelo.FutbolAmericano;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AmericanoDAO implements InterfazDAO{
    public AmericanoDAO() {
    }

    @Override
    public boolean insertar(Object obj) throws SQLException {
        String sqlInsert = "INSERT INTO FutbolAmericanoDB (pais, equipo, jugador, numero, posicion, foto) VALUES (?,?,?,?,?,?)";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("FutbolAmericanoDB.db").getConnection().prepareStatement(sqlInsert);
        pstm.setString(1, ((FutbolAmericano) obj).getPais());
        pstm.setString(2, ((FutbolAmericano) obj).getEquipo());
        pstm.setString(3, ((FutbolAmericano) obj).getJugador());
        pstm.setString(4, ((FutbolAmericano) obj).getNumero());
        pstm.setString(5, ((FutbolAmericano) obj).getPosicion());
        pstm.setString(6, ((FutbolAmericano) obj).getFoto());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }
    @Override
    public boolean update(Object obj) throws SQLException {
        String sqlUpdate = "UPDATE FutbolAmericanoDB SET pais = ?, equipo = ?, jugador = ?, numero = ?, posicion = ?, foto = ? WHERE id = ? ; ";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("FutbolAmericanoDB.db").getConnection().prepareStatement(sqlUpdate);
        pstm.setString(1, ((FutbolAmericano) obj).getPais());
        pstm.setString(2, ((FutbolAmericano) obj).getEquipo());
        pstm.setString(3, ((FutbolAmericano) obj).getJugador());
        pstm.setString(4, ((FutbolAmericano) obj).getNumero());
        pstm.setString(5, ((FutbolAmericano) obj).getPosicion());
        pstm.setString(6, ((FutbolAmericano) obj).getFoto());
        pstm.setInt(7, ((FutbolAmericano) obj).getId());
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        String sqlDelete = "DELETE FROM FutbolAmericanoDB WHERE id = ? ;";
        int rowCount = 0;
        PreparedStatement pstm = ConexionSingleton.get_instance("FutbolAmericanoDB.db").getConnection().prepareStatement(sqlDelete);
        pstm.setInt(1, Integer.parseInt(id));
        rowCount = pstm.executeUpdate();
        return rowCount > 0;
    }

    @Override
    public ArrayList obtenerTodo() throws SQLException {
        String sql = "SELECT * FROM FutbolAmericanoDB ;";
        ArrayList<FutbolAmericano> resultado = new ArrayList<>();
        Statement stn = ConexionSingleton.get_instance("FutbolAmericanoDB.db").getConnection().createStatement();
        ResultSet rst = stn.executeQuery(sql);
        while(rst.next()){
            resultado.add((new FutbolAmericano(rst.getInt(1),rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),
                    rst.getString(6), rst.getString(7))));

        }
        return resultado;
    }

    @Override
    public Object buscarPorId(String id) throws SQLException {
        String sql = "Select * FROM FutbolAmericanoDB WHERE id = ? ; ";
        FutbolAmericano futAme = null;
        PreparedStatement pstm = ConexionSingleton.get_instance("FutbolAmericanoDB.db").getConnection().prepareStatement(sql);
        pstm.setInt(1, Integer.parseInt(id));
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            futAme = new FutbolAmericano(rst.getInt(1),rst.getString(2),
                    rst.getString(3), rst.getString(4), rst.getString(5),
                    rst.getString(6), rst.getString(7));
            return  futAme;

        }
        return null;
    }
}
