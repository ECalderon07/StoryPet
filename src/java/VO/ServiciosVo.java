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
public class ServiciosVo {

    private String idServicio;
    private String Servicio;

    public ServiciosVo(String idServicio, String Servicio) {
        this.idServicio = idServicio;
        this.Servicio = Servicio;
    }

    public ServiciosVo() {
    }

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public String getTipoServicio() {
        return Servicio;
    }

    public void setTipoServicio(String Servicio) {
        this.Servicio = Servicio;
    }

}
