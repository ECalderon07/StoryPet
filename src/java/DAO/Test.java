/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Config.Conexion;
import VO.CorreoVo;
import VO.UsuarioVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Edwin
 */
public class Test extends Conexion {

    Conexion conexion = new Conexion();
    private Connection Conn = null;
    private Statement puente = null;
    private ResultSet rs = null;

    private final Properties propiedades = new Properties();
    private Session session;
    private String password;

    private void datosConexion() {
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.starls.enable", "true");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.mail.sender", "storypet.info@gmail.com");
        propiedades.put("mail.smtp.user", "storypet.info@gmail.com");
        propiedades.put("mail.smtp.auth", "true");
        password = "petland07";
        propiedades.put("mail.smtp.starttls.enable", "true");//Habilitar el envio del correo
        propiedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Ejecutar el envio del correo
        session = Session.getDefaultInstance(propiedades);

    }

    public void datosConexion2() {
        propiedades.put("mail.smtp.host", "smtp.gmail.com");
        propiedades.put("mail.smtp.starls.enable", "true");
        propiedades.put("mail.smtp.port", "587");
        propiedades.put("mail.smtp.mail.sender", "storypet.info@gmail.com");
        propiedades.put("mail.smtp.user", "storypet.info@gmail.com");
        propiedades.put("mail.smtp.auth", "true");
        password = "petland07";
        propiedades.put("mail.smtp.starttls.enable", "true");//Habilitar el envio del correo
        propiedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");//Ejecutar el envio del correo
        session = Session.getDefaultInstance(propiedades);

    }

    public void envioCorreo(String Destinatario, String Asunto, String Mensaje) {
        datosConexion();
        try {
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress((String) propiedades.getProperty("mail.smtp.mail.sender")));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(Destinatario));//destinatario
            mensaje.setSubject(Asunto);//asunto
            mensaje.setText(Mensaje);//correo

            Transport transporte = session.getTransport("smtp");
            transporte.connect((String) propiedades.getProperty("smtp.mail.user"), password);
            transporte.sendMessage(mensaje, mensaje.getAllRecipients());
            transporte.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
    
        public void envioContraseña(String Contraseña,String Correo) {
        datosConexion();
        try {
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress((String) propiedades.getProperty("mail.smtp.mail.sender")));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(Correo));//destinatario
            mensaje.setText(Contraseña);//contraseña

            Transport transporte = session.getTransport("smtp");
            transporte.connect((String) propiedades.getProperty("smtp.mail.user"), password);
            transporte.sendMessage(mensaje, mensaje.getAllRecipients());
            transporte.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public boolean AgregarRegistro(CorreoVo correoVo) {
        String Sql = "INSERT INTO correo(Destinatario,Asunto,Mensaje,Fecha) VALUES ('" + correoVo.getDestinatario() + "', '" + correoVo.getAsunto() + "','" + correoVo.getMensaje() + "','" + correoVo.getFecha() + "'); ";
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
        ArrayList<CorreoVo> List = new ArrayList<>();
        String Sql = "SELECT Destinatario,Asunto,Mensaje,Fecha FROM correo";
        try {
            conn = conexion.obtenerConexion();
            puente = conn.prepareStatement(Sql);
            rs = puente.executeQuery(Sql);

            while (rs.next()) {
                CorreoVo correoVo = new CorreoVo();

                correoVo.setDestinatario(rs.getString("Destinatario"));
                correoVo.setAsunto(rs.getString("Asunto"));
                correoVo.setMensaje(rs.getString("Mensaje"));
                correoVo.setFecha(rs.getString("Fecha"));

                List.add(correoVo);
            }

        } catch (Exception e) {
            e.getStackTrace();
        }

        return List;
    }
}
