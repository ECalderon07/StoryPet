/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.CRUD_ESPECIES;
import Config.Conexion;
import VO.EspeciesVO;
import VO.RazasVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class EspeciesDAO extends Conexion implements CRUD_ESPECIES {

    Conexion conexion = new Conexion();
    private Connection Conn = null;
    private Statement puente = null;
    private ResultSet rs = null;
    public boolean Operacion = false;

    EspeciesVO especiesVO = new EspeciesVO();

    @Override
    public boolean Agregar(EspeciesVO especiesVO) {
        String Sql = "INSERT INTO especies(Nombre) VALUES ('" + especiesVO.getNombre() +"');";
        
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);

        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public boolean Editar(EspeciesVO especiesVO) {
        String Sql = "UPDATE especies SET Nombre='" + especiesVO.getNombre() + "' WHERE Especie='" + especiesVO.getEspecie() + "'";

        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);

        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public boolean Eliminar(int Especie) {
        String Sql = "DELETE FROM especies WHERE Especie=" + Especie;
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    public List<EspeciesVO> Listar() {
        ArrayList<EspeciesVO> ListaEspecies = new ArrayList<EspeciesVO>();
        String Sql = "select*from especies;";
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);

            ResultSet rs = puente.executeQuery(Sql);

            while (rs.next()) {
                especiesVO.setEspecie(rs.getInt("Especie"));
                especiesVO.setNombre(rs.getString("Nombre"));
                ListaEspecies.add(especiesVO);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return ListaEspecies;
    }

}
