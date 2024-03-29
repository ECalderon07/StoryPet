/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Equipo 17 A 510
 */
package DAO;

import Config.Conexion;
import VO.CorreoVo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ServidorMail {

    private final Properties propiedades = new Properties();
    private Session session;
    private String password;

    CorreoVo correoVo = new CorreoVo();

    Conexion conexion = new Conexion();

    private Connection Conn = null;
    private Statement puente = null;
    private ResultSet rs = null;

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

    public void envioClave(String Destinatario, String Asunto, String Clave) {
        datosConexion();
        try {
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress((String) propiedades.getProperty("mail.smtp.mail.sender")));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(Destinatario));//destinatario
            mensaje.setSubject(Asunto);//asunto
            mensaje.setText(Clave);//correo

            Transport transporte = session.getTransport("smtp");
            transporte.connect((String) propiedades.getProperty("smtp.mail.user"), password);
            transporte.sendMessage(mensaje, mensaje.getAllRecipients());
            transporte.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    public boolean AgregarCorreo(CorreoVo correoVO) {

        boolean Operacion = false;
        String Sql = "INSERT INTO correo(Destinatario,Asunto,Mensaje) VALUES ('" + correoVO.getDestinatario() + "','" + correoVO.getAsunto() + "','" + correoVO.getMensaje() + "');";
        Operacion = true;
        try {
            Conn = conexion.obtenerConexion();
            puente = Conn.prepareStatement(Sql);
            puente.executeUpdate(Sql);

        } catch (Exception e) {
            e.getStackTrace();
        }
        return Operacion;
    }

    public static void main(String[] args) {
        new ServidorMail();
    }
}
