/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Conexion;
import DAO.UsuarioDAO;
import Dao.Test;
import VO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Edwin
 */
@WebServlet(name = "ControladorContraseña", urlPatterns = {"/Recuperar"})
public class ControladorContraseña extends HttpServlet {

    Conexion conexion = new Conexion();
    Connection cnn = conexion.obtenerConexion();

    UsuarioVO usuarioVO = new UsuarioVO();
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    String Contraseña = Clave();
    String Correo="";
    
    Test test = new Test();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        Correo = request.getParameter("correo");
        Contraseña = Clave();

        
        test.datosConexion2();

        if (usuarioDAO.ValidarUsuario(Correo)) {//existe el usuario

            if (usuarioDAO.ActualizarContraseña(Correo, Contraseña)) {//actualizo
                test.envioContraseña(Contraseña, Correo);//enviar

            }

        }

    }

    public static String Clave() {
        char Caracter;
        String Clave = "";
        String Contraseña = "";
        String CaracteresNoDeseados = "";
        Random rnd = new Random();

        for (int i = 0; i < 7; i++) {
            if (i < 4) {
                Clave += rnd.nextInt(10);
            } else {
                do {
                    Caracter = (char) (rnd.nextInt(91) + 65);
                } while (CaracteresNoDeseados.indexOf(Caracter) >= 0);

                Contraseña = Clave += Caracter;
            }
        }
        return (Contraseña);
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
        if (usuarioDAO.ValidarUsuario(Correo)) {//existe el usuario

            if (usuarioDAO.ActualizarContraseña(Correo, Contraseña)) {//actualizo
                test.envioContraseña(Contraseña, Correo);//enviar

            }

        }
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
