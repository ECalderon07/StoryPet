/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Daniel
 */
public class HistorialVo {

    private String Fecha, Novedad, FKServicio, FKMascota, FKUsuario, IdHistorialClinico;

    public HistorialVo(String Fecha, String Novedad, String FKServicio, String FKMascota, String FKUsuario, String IdHistorialClinico) {
        this.Fecha = Fecha;
        this.Novedad = Novedad;
        this.FKServicio = FKServicio;
        this.FKMascota = FKMascota;
        this.FKUsuario = FKUsuario;
        this.IdHistorialClinico = IdHistorialClinico;
    }

    public HistorialVo() {
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getNovedad() {
        return Novedad;
    }

    public void setNovedad(String Novedad) {
        this.Novedad = Novedad;
    }

    public String getFKServicio() {
        return FKServicio;
    }

    public void setFKServicio(String FKServicio) {
        this.FKServicio = FKServicio;
    }

    public String getFKMascota() {
        return FKMascota;
    }

    public void setFKMascota(String FKMascota) {
        this.FKMascota = FKMascota;
    }

    public String getFKUsuario() {
        return FKUsuario;
    }

    public void setFKUsuario(String FKUsuario) {
        this.FKUsuario = FKUsuario;
    }

    public String getIdHistorialClinico() {
        return IdHistorialClinico;
    }

    public void setIdHistorialClinico(String IdHistorialClinico) {
        this.IdHistorialClinico = IdHistorialClinico;
    }

}
