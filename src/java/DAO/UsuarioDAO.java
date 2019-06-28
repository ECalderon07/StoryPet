/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.CRUD_USUARIO;
import Config.Conexion;
import VO.UsuarioVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class UsuarioDAO extends Conexion implements CRUD_USUARIO {

    Conexion conexion = new Conexion();

    private Connection Conn = null;
    private Statement puente = null;
    private ResultSet rs = null;

    UsuarioVO usuario = new UsuarioVO();

    public UsuarioDAO() {
    }

    @Override
    public boolean AgregarRegistro(UsuarioVO usuarioVo) {
        String Sql = "insert into usuarios(idUsuario,Usuario,Contraseña,Nombres,Apellidos,Telefono,Correo,Rol,Estado) values('" + usuarioVo.getIdUsuario() + "', '" + usuarioVo.getUsuario() + "','" + usuarioVo.getContraseña() + "','" + usuarioVo.getNombres() + "','" + usuarioVo.getApellidos() + "','" + usuarioVo.getTelefono() + "','" + usuarioVo.getCorreo() + "','" + usuarioVo.getRol() + "' ,'" + usuarioVo.getEstado() + "' ) ";
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
    public boolean ActualizarRegistro(UsuarioVO usuarioVo) {
        String Sql = "UPDATE usuarios SET Usuario='" + usuarioVo.getUsuario() + "' , Nombres='" + usuarioVo.getNombres() + "' , Apellidos='" + usuarioVo.getApellidos() + "' ,  Telefono='" + usuarioVo.getTelefono() + "', Correo='" + usuarioVo.getCorreo() + "' WHERE idUsuario='" + usuarioVo.getIdUsuario() + "' ";
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
    public boolean EliminarRegistro(int idUsuario) {
        String Sql = "DELETE FROM usuarios where idUsuario=" + idUsuario;
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    public boolean CambiarContra(UsuarioVO usuarioVo) {
        String Sql = "UPDATE usuarios SET Contraseña='" + usuarioVo.getContraseña() + "' where idUsuario='" + usuarioVo.getIdUsuario() + "'; ";
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return false;
    }

    public boolean Estado(int Estado, int idUsuario) {
        String Sql = "UPDATE usuarios SET Estado='" + Estado + "' where idUsuario='" + idUsuario + "' ; ";
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);
        } catch (Exception e) {
            e.getStackTrace();
        }

        return false;
    }

    public ArrayList<UsuarioVO> Listar() {
        ArrayList<UsuarioVO> List = new ArrayList<>();
        String Sql = "select idUsuario,Usuario,Nombres,Apellidos,Telefono,Correo,Rol from usuarios where Rol = 'veterinario' and Estado=1;";
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);

            while (rs.next()) {
                UsuarioVO usuarioVO = new UsuarioVO();

                usuarioVO.setIdUsuario(rs.getString("idUsuario"));
                usuarioVO.setUsuario(rs.getString("Usuario"));
                usuarioVO.setNombres(rs.getString("Nombres"));
                usuarioVO.setApellidos(rs.getString("Apellidos"));
                usuarioVO.setTelefono(rs.getString("Telefono"));
                usuarioVO.setCorreo(rs.getString("Correo"));
                usuarioVO.setRol(rs.getString("Rol"));

                List.add(usuarioVO);

            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return List;
    }

    public List ListarOcultos() {
        ArrayList<UsuarioVO> List = new ArrayList<>();
        String Sql = "select idUsuario,Usuario,Nombres,Apellidos,Telefono,Correo,Rol from usuarios where Rol = 'user' and Estado=0;";
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);

            while (rs.next()) {
                UsuarioVO usuarioVO = new UsuarioVO();

                usuarioVO.setIdUsuario(rs.getString("idUsuario"));
                usuarioVO.setUsuario(rs.getString("Usuario"));
                usuarioVO.setNombres(rs.getString("Nombres"));
                usuarioVO.setApellidos(rs.getString("Apellidos"));
                usuarioVO.setTelefono(rs.getString("Telefono"));
                usuarioVO.setCorreo(rs.getString("Correo"));
                usuarioVO.setRol(rs.getString("Rol"));

                List.add(usuarioVO);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return List;
    }

    public UsuarioVO ListarId(String idUsuario) {
        String Sql = "select idUsuario,Usuario,Nombres,Apellidos,Telefono,Correo,Rol from usuarios where idUsuario=" + idUsuario;
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);
            while (rs.next()) {
                usuario.setIdUsuario(rs.getString("idUsuario"));
                usuario.setUsuario(rs.getString("Usuario"));
                usuario.setNombres(rs.getString("Nombres"));
                usuario.setApellidos(rs.getString("Apellidos"));
                usuario.setTelefono(rs.getString("Telefono"));
                usuario.setCorreo(rs.getString("Correo"));
                usuario.setRol(rs.getString("Rol"));
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
        return usuario;
    }

    public boolean ValidarUsuario(String Correo) {
        boolean Operacion = false;
        try {
            Conn = this.obtenerConexion();
            puente = Conn.createStatement();
            rs = puente.executeQuery("select * from usuarios where correo = '" + Correo + "'");

            if (rs.next()) {
                Operacion = true;
            }
            this.cerrarConexion();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Operacion;
    }

    public boolean ActualizarContraseña(String Correo, String Contraseña) {
        boolean Operacion = false;
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.createStatement();
            puente.executeUpdate("UPDATE usuarios SET Correo='" + Correo + "' where Contraseña='" + Contraseña + "' ; ");
            Operacion = true;

        } catch (Exception e) {
            //Logger.getLogger(ModeloDao.UsuarioDao.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return Operacion;

    }

    public UsuarioVO autenticarUsuario(UsuarioVO usuarioVo) {

        String Correo = usuarioVo.getCorreo();
        String Clave = usuarioVo.getContraseña();

        String Sql = "select IdUsuario,Usuario,Contraseña,Nombres,Apellidos,Telefono,Correo,Rol from usuarios where Correo='" + Correo + "' and Contraseña='" + Clave + "' ;";

        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);
            while (rs.next()) {

                usuarioVo.setIdUsuario(rs.getString("IdUsuario"));
                usuarioVo.setUsuario(rs.getString("Usuario"));
                usuarioVo.setNombres(rs.getString("Nombres"));
                usuarioVo.setApellidos(rs.getString("Apellidos"));
                usuarioVo.setTelefono(rs.getString("Telefono"));
                usuarioVo.setCorreo(rs.getString("Correo"));
                usuarioVo.setContraseña(rs.getString("Contraseña"));
                usuarioVo.setRol(rs.getString("Rol"));

            }
            this.cerrarConexion();

        } catch (Exception e) {
            e.printStackTrace();
            //Logger.getLogger(DAO.UsuarioDAO.class.getName()).log(Level.SEVERE, null, e);
        }
        return usuarioVo;
    }

    public List ListarVeterinario() {
        ArrayList<UsuarioVO> Lista = new ArrayList<>();
        String Sql = "SELECT * from usuarios; ";
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);

            while (rs.next()) {
                UsuarioVO usuarioVO = new UsuarioVO();
                usuarioVO.setNombres(rs.getString("nombres"));
                usuarioVO.setApellidos(rs.getString("Apellidos"));
                usuarioVO.setTelefono(rs.getString("Telefono"));
                usuarioVO.setCorreo(rs.getString("Correo"));
                usuarioVO.setRol(rs.getString("Rol"));
                Lista.add(usuarioVO);
            }

        } catch (Exception e) {

        }
        return Lista;
    }

}
