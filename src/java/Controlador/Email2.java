/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;


import DAO.ServidorMail2;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edwin
 */
@WebServlet(name = "Email2", urlPatterns = {"/Email2"})
public class Email2 extends HttpServlet {

    private final Properties propiedades = new Properties();
    private Session session;
    private String password;

    private String Asunto;
    private String Destinatario;
    private String Mensaje;

    ServidorMail2 sv = new ServidorMail2();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Asunto = request.getParameter("asunto");
        Destinatario = request.getParameter("destinatario");
        Mensaje = request.getParameter("mensaje");
        try {
            //validaruser
            sv.envioCorreo(Destinatario, Asunto, Mensaje);
            request.setAttribute("message", "<script>alert('Correo enviado con exito!')</script>");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error", e);

        }
    }

//    public Email2() {
//        envioCorreo(Asunto, Destinatario, Mensaje);
//    }

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
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress("storypet.info@gmail.com"));//destinatario
            mensaje.setSubject(Asunto);//asunto
            mensaje.setText(Destinatario + "\n" + Mensaje);//correo

            Transport transporte = session.getTransport("smtp");
            transporte.connect((String) propiedades.getProperty("smtp.mail.user"), password);
            transporte.sendMessage(mensaje, mensaje.getAllRecipients());
            transporte.close();
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
