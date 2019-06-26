/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ServicioDAO;
import VO.ServiciosVo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brayan
 */
@WebServlet(name = "Servicios", urlPatterns = {"/Servicios"})
public class Servicios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String action = request.getParameter("accion");

        ServiciosVo servicioVO = new ServiciosVo();
        ServicioDAO servicioDAO = new ServicioDAO();

        String acceso = "";
        String inicio = "veterinario.jsp";
        String list = "ConsultarServicio.jsp";
        String Editar = "actualizarServicio.jsp";

        if (action.equalsIgnoreCase("Registrar")) {
            String Servicio = request.getParameter("txtServicio");
            servicioVO.setTipoServicio(Servicio);
            if (servicioDAO.AgregarRegistro(servicioVO)) {
                request.setAttribute("error", "<script> alert('Error en el registro') </script>");
            } else {
                request.setAttribute("exito", "<script> alert('Servicio registrado') </script>");
            }
            acceso = inicio;

        } else if (action.equalsIgnoreCase("Editar")) {
            request.setAttribute("idServicio", request.getParameter("idServicio"));
            acceso = Editar;
        } else if (action.equalsIgnoreCase("Eliminar")) {
            int id = Integer.parseInt(request.getParameter("idServicio"));
            if (servicioDAO.EliminarRegistro(id)) {
                request.setAttribute("error", "<script> alert('Error en la eliminacion') </script>");
            } else {
                request.setAttribute("exito", "<script> alert('Servicio eliminado') </script>");
            }
            acceso = list;

        } else if (action.equalsIgnoreCase("listar")) {
            acceso = list;
        } else if (action.equalsIgnoreCase("Actualizar")) {

            String Servicio = request.getParameter("txtServicio");
            String IdServicio = request.getParameter("txtidServicio");

            servicioVO.setTipoServicio(Servicio);
            servicioVO.setIdServicio(IdServicio);

            if (servicioDAO.ActualizarRegistro(servicioVO)) {
                request.setAttribute("error", "<script> alert('Error en la actualizacion') </script>");
            } else {
                request.setAttribute("exito", "<script> alert('Servicio actualizado') </script>");
            }
            acceso = inicio;

        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);

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
