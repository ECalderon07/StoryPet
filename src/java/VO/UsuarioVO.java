/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Admin
 */
public class UsuarioVO {

    private String IdUsuario;
    private String Usuario;
    private String Contraseña;
    private String Nombres;
    private String Apellidos;
    private String Telefono;
    private String Correo;
    private String Rol;
    private String Estado="1";

    public UsuarioVO(String Correo, String Contraseña) {

        this.Contraseña = Contraseña;
        this.Correo = Correo;
    }

    public UsuarioVO(String IdUsuario, String Usuario, String Contraseña, String Nombres, String Apellidos, String Telefono, String Correo, String Rol, String Estado) {
        this.IdUsuario = IdUsuario;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Rol = Rol;
        this.Estado = Estado;
    }

    public UsuarioVO(String IdUsuario, String Usuario, String Nombres, String Apellidos, String Telefono, String Correo, String Rol) {
        this.IdUsuario = IdUsuario;
        this.Usuario = Usuario;

        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Rol = Rol;

    }

    public UsuarioVO() {
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String Rol) {
        this.Rol = Rol;
    }

}
