/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.CRUD_RAZAS;
import Config.Conexion;
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
public class RazasDAO extends Conexion implements CRUD_RAZAS {

    Conexion conexion = new Conexion();
    private Connection Conn = null;
    private Statement puente = null;
    private ResultSet rs = null;

    @Override
    public boolean Agregar(RazasVO razasVO) {
        String Sql = "insert into razas(id,Raza,Especie) values ('" + razasVO.getId() + "','" + razasVO.getRaza() + "','" + razasVO.getEspecie() + "');";
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
    public boolean Editar(RazasVO razasVO) {
        String Sql = "UPDATE razas SET Raza='" + razasVO.getRaza() + "',Especie='" + razasVO.getEspecie() + "' WHERE Id='" + razasVO.getId()+ "'";
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
    public boolean Eliminar(int id) {
        String Sql = "DELETE FROM razas WHERE id=" + id;
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

//    public List Listar(String Especie) {
//        ArrayList<RazasVO> ListaRazas = new ArrayList<RazasVO>();
//        String Sql = "SELECT razas.idRaza, razas.Nombre FROM especies INNER JOIN razas ON especies.idEspecie = razas.IdEspecie where especies.idEspecie='" + Especie + "' ";
//        try {
//            Conn = conexion.obtenerConexion();
//            puente = conn.prepareStatement(Sql);
//            rs = puente.executeQuery(Sql);
//
//            while (rs.next()) {
//                RazasVO razasVO = new RazasVO();
//
//                razasVO.setIdRaza(rs.getString("razas.idRaza"));
//                razasVO.setNombre(rs.getString("razas.Nombre"));
//
//                ListaRazas.add(razasVO);
//            }
//
//        } catch (Exception e) {
//            e.getStackTrace();
//        }
//
//        return ListaRazas;
//    }
//    
    public List Listar() {
        ArrayList<RazasVO> List = new ArrayList<RazasVO>();
        String Sql = "SELECT razas.id, razas.Raza FROM especies INNER JOIN razas ON especies.Especie = razas.Especie ";
        try {
            Conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);

            while (rs.next()) {
                RazasVO razasVO = new RazasVO();

                razasVO.setId(rs.getInt("razas.idRaza"));
                razasVO.setRaza(rs.getString("razas.Nombre"));

                List.add(razasVO);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return List;
    }

}
