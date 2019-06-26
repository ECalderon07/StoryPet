/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.Test;
import VO.CorreoVo;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Edwin
 */
public class Mail extends HttpServlet {
    
    Date date = new Date();
    Test test = new Test();
    CorreoVo correoVo = new CorreoVo();

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
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String Destinatario = request.getParameter("Destinatario");
        String Asunto = request.getParameter("Asunto");
        String Mensaje = request.getParameter("Mensaje");
        String Usuario = request.getParameter("FkUsuario");
        
        SimpleDateFormat hourdateFormat =new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String Fecha = hourdateFormat.format(new Date());
        

        correoVo.setDestinatario(Destinatario);
        correoVo.setAsunto(Asunto);
        correoVo.setMensaje(Mensaje);
        correoVo.setFecha(Fecha);

        try {
            test.envioCorreo(Destinatario, Asunto, Mensaje);
            request.setAttribute("message", "Correo enviado con exito!");

            test.AgregarRegistro(correoVo);
            request.getRequestDispatcher("/Form.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error", e);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
