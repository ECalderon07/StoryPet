/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author Edwin
 */
public class CorreoVo {

    private int IdCorreo;
    private String Destinatario;
    private String Asunto;
    private String Mensaje;
    private String Fecha;

    public CorreoVo() {
    }

    public CorreoVo(int IdCorreo, String Destinatario, String Asunto, String Mensaje, String Fecha) {
        this.IdCorreo = IdCorreo;
        this.Destinatario = Destinatario;
        this.Asunto = Asunto;
        this.Mensaje = Mensaje;
        this.Fecha = Fecha;
    }

    public int getIdCorreo() {
        return IdCorreo;
    }

    public void setIdCorreo(int IdCorreo) {
        this.IdCorreo = IdCorreo;
    }

    public String getDestinatario() {
        return Destinatario;
    }

    public void setDestinatario(String Destinatario) {
        this.Destinatario = Destinatario;
    }

    public String getAsunto() {
        return Asunto;
    }

    public void setAsunto(String Asunto) {
        this.Asunto = Asunto;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

}
