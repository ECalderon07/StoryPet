/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Interfaces.CRUD_HISTORIAL;
import VO.HistorialVo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
public class HistorialDao extends Conexion implements CRUD_HISTORIAL {

    Conexion conexion = new Conexion();

    private Connection conn = null;
    private Statement puente = null;
    private ResultSet rs = null;

    HistorialVo historialVo = new HistorialVo();

    @Override
    public boolean Agregar(HistorialVo historialVo) {
        String Sql = "INSERT INTO historialclinico (Fecha,Novedad,FKServicio,FKMascota,FKUsuario) VALUES('" + historialVo.getFecha() + "','" + historialVo.getNovedad() + "','" + historialVo.getFKServicio() + "','" + historialVo.getFKMascota() + "','" + historialVo.getFKUsuario() + "'); ";
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
    public boolean Editar(HistorialVo historialVo) {
        String Sql = "UPDATE historialclinico SET Novedad = '" + historialVo.getNovedad() + "' WHERE IdHistorialClinico = '" + historialVo.getIdHistorialClinico() + "' ; ";
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
        String Sql = "DELETE FROM historialclinico WHERE IdHistorialClinico='" + id + "';";
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    public HistorialVo ListarId(String IdHistorialClinico) {
        String Sql = "SELECT historialclinico.idHistorialClinico,historialclinico.Fecha,historialclinico.Novedad,servicios.Servicio,mascotas.Nombre FROM servicios INNER JOIN historialclinico on servicios.idServicio=historialclinico.FKServicio INNER JOIN mascotas ON historialclinico.FKMascota=mascotas.idMascota where historialclinico.idHistorialClinico =" + IdHistorialClinico;
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);
            while (rs.next()) {

                historialVo.setIdHistorialClinico(rs.getString("historialclinico.idHistorialClinico"));
                historialVo.setFecha(rs.getString("historialclinico.Fecha"));
                historialVo.setNovedad(rs.getString("historialclinico.Novedad"));
                historialVo.setFKServicio(rs.getString("servicios.Servicio"));
                historialVo.setFKMascota(rs.getString("mascotas.Nombre"));

            }
        } catch (Exception e) {
        }
        return historialVo;
    }

    public List Listar() {
        ArrayList<HistorialVo> List = new ArrayList<>();
        String Sql = "SELECT historialclinico.idHistorialClinico,historialclinico.Novedad,servicios.TipoServicio,mascotas.Nombre FROM servicios INNER JOIN historialclinico on servicios.idServicio=historialclinico.IdServicio INNER JOIN mascotas ON historialclinico.IdMascota=mascotas.idMascota";
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);
            rs = puente.executeQuery(Sql);
            while (rs.next()) {
                HistorialVo historialVo = new HistorialVo();

                historialVo.setIdHistorialClinico(rs.getString("idHistorialClinico"));
                historialVo.setNovedad(rs.getString("Novedad"));
                historialVo.setFKServicio(rs.getString("servicios.TipoServicio"));
                historialVo.setFKMascota(rs.getString("mascotas.Nombre"));
                List.add(historialVo);
            }
        } catch (Exception e) {

        }
        return List;
    }

}
