/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Config.Conexion;
import Interfaces.CRUD_SERVICIOS;
import VO.ServiciosVo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ServicioDAO extends Conexion implements CRUD_SERVICIOS {

    Conexion conexion = new Conexion();
    private Connection Conn = null;
    private Statement puente = null;
    private ResultSet rs = null;

    ServiciosVo servicioVo = new ServiciosVo();

    @Override
    public boolean AgregarRegistro(ServiciosVo serviciosVo) {
        String Sql = "insert into servicios(Servicio)values('" + serviciosVo.getTipoServicio() + "')";
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean ActualizarRegistro(ServiciosVo serviciosVo) {
        String Sql = "UPDATE `servicios` SET `Servicio` ='" + serviciosVo.getTipoServicio() + "'WHERE `servicios`.`IdServicio`=" + serviciosVo.getIdServicio();
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean EliminarRegistro(int id) {
        String Sql = "DELETE FROM `servicios` WHERE `servicios`.`IdServicio`=" + id;
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List Listar() {
        ArrayList<ServiciosVo> List = new ArrayList<>();
        String Sql = "Select * from servicios;";
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);
            while (rs.next()) {
                ServiciosVo serviciosVo = new ServiciosVo();
                serviciosVo.setIdServicio(rs.getString("IdServicio"));
                serviciosVo.setTipoServicio(rs.getString("Servicio"));
                List.add(serviciosVo);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return List;
    }

    public ServiciosVo ListarId(String idServicio) {
        String Sql = "Select * from servicios where idServicio =" + idServicio;
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);
            while (rs.next()) {
                
                servicioVo.setIdServicio(rs.getString("IdServicio"));
                servicioVo.setTipoServicio(rs.getString("Servicio"));
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return servicioVo;
    }

}
