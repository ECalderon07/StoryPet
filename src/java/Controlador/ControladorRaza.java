/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Config.Conexion;
import VO.RazasVO;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "ControladorRaza", urlPatterns = {"/ControladorRaza"})
public class ControladorRaza extends HttpServlet {

    private Gson gson = new Gson();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Conexion conexion = new Conexion();
        Connection cnn = conexion.obtenerConexion();

        int especie = Integer.parseInt(request.getParameter("especie"));
        String sql = "SELECT * FROM razas WHERE especie=?";

        try {
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, especie);
            ResultSet resultado = ps.executeQuery();

            ArrayList<RazasVO> arrayList = new ArrayList<RazasVO>();
            while (resultado.next()) {
                RazasVO razaVo = new RazasVO();
                razaVo.setId(resultado.getInt("id"));
                razaVo.setRaza(resultado.getString("raza"));
                razaVo.setEspecie(resultado.getInt("especie"));
                arrayList.add(razaVo);
            }

            String employeeJsonString = this.gson.toJson(arrayList);

            PrintWriter out = response.getWriter();
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(employeeJsonString);
            out.flush();

        } catch (SQLException ex) {
            Logger.getLogger(ControladorRaza.class.getName()).log(Level.SEVERE, null, ex);
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
