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
public class MascotasVO {

    private String idMascota;
    private String Nombre;
    private String FechaNacimiento;
    private String Sexo;
    private String FKEspecies;
    private String FKRaza;
    private String FKUsuario;
    private String Estado;

    public MascotasVO() {
    }

    public MascotasVO(String idMascota, String Nombre, String FechaNacimiento, String Sexo, String FKEspecies, String FKRaza, String FKUsuario, String Estado) {
        this.idMascota = idMascota;
        this.Nombre = Nombre;
        this.FechaNacimiento = FechaNacimiento;
        this.Sexo = Sexo;
        this.FKEspecies = FKEspecies;
        this.FKRaza = FKRaza;
        this.FKUsuario = FKUsuario;
        this.Estado = Estado;
    }

    public String getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(String idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String FechaNacimiento) {
        this.FechaNacimiento = FechaNacimiento;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getFKEspecies() {
        return FKEspecies;
    }

    public void setFKEspecies(String FKEspecies) {
        this.FKEspecies = FKEspecies;
    }

    public String getFKRaza() {
        return FKRaza;
    }

    public void setFKRaza(String FKRaza) {
        this.FKRaza = FKRaza;
    }

    public String getFKUsuario() {
        return FKUsuario;
    }

    public void setFKUsuario(String FKUsuario) {
        this.FKUsuario = FKUsuario;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
}
