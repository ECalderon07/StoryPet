/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.CRUD_MASCOTA;
import Config.Conexion;
import VO.MascotasVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MascotasDAO extends Conexion implements CRUD_MASCOTA {

    Conexion conexion = new Conexion();

    private Connection Conn = null;
    private Statement puente = null;
    private ResultSet rs = null;

    MascotasVO mascotas = new MascotasVO();

    @Override
    public boolean Agregar(MascotasVO mascotasVO) {
        String Sql = "insert into mascotas(Nombre,FechaNacimiento,Sexo,fkEspecies,FKRaza,FKUsuario) values ('" + mascotasVO.getNombre() + "','" + mascotasVO.getFechaNacimiento() + "','" + mascotasVO.getSexo() + "','" + mascotasVO.getFKEspecies() + "','" + mascotasVO.getFKRaza() + "','" + mascotasVO.getFKUsuario() + "');";
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
    public boolean Editar(MascotasVO mascotasVO) {
        String Sql = "Update mascotas set Nombre='" + mascotasVO.getNombre() + "'  where IdMascota='" + mascotasVO.getIdMascota() + "');";
        //UPDATE mascotas SET Nombre=[value-2] WHERE `IdMascota`=[value-1]
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    @Override
    public boolean Eliminar(int id) {
        String Sql = "DELETE FROM mascotas where IdMascota=" + id;
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);

        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    public List Listar() {
        ArrayList<MascotasVO> List = new ArrayList<>();
        String Sql = "SELECT IdMascota,Nombre FROM mascotas";
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);
            while (rs.next()) {
                MascotasVO mascotasVo = new MascotasVO();
                mascotasVo.setIdMascota(rs.getString("IdMascota"));
                mascotasVo.setNombre(rs.getString("Nombre"));
                List.add(mascotasVo);
            }
        } catch (Exception e) {
            e.getStackTrace();
        }
        return List;
    }

    public MascotasVO listarId(String id) {
        String Sql = "SELECT idMascota,Nombre, FechaNacimiento, Sexo, razas.raza, FKUsuario FROM mascotas INNER JOIN razas ON mascotas.FKRaza = razas.id where IdMascota=" + id;
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);

            while (rs.next()) {
                mascotas.setIdMascota(rs.getString("idMascota"));
                mascotas.setNombre(rs.getString("Nombre"));
                mascotas.setFechaNacimiento(rs.getString("FechaNacimiento"));
                mascotas.setSexo(rs.getString("Sexo"));
                mascotas.setFKRaza(rs.getString("razas.raza"));
                mascotas.setFKUsuario(rs.getString("FKUsuario"));
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return mascotas;
    }

}
