/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ServidorMail;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edwin
 */
public class EmailEnvio extends HttpServlet {

    private final Properties propiedades = new Properties();
    private Session session;
    private String password;

    private String Asunto;
    private String Destinatario;
    private String Mensaje;

    ServidorMail sv = new ServidorMail();

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

    public EmailEnvio() {
        envioCorreo(Asunto, Destinatario, Mensaje);
    }

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
    
        public void envioCorreo(String Asunto, String Destinatario, String Mensaje) {
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
            out.print("Exito");
        } catch (Exception e) {
            out.print("Error" + e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
