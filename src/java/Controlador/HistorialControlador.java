/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.HistorialDao;
import VO.HistorialVo;
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
@WebServlet(name = "HistorialControlador", urlPatterns = {"/Historial"})
public class HistorialControlador extends HttpServlet {

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
        HistorialVo historialVo = new HistorialVo();
        HistorialDao dao = new HistorialDao();

        String acceso = "";

        String ListarHistoUsuario = "ConsultaHistorialUsuario.jsp";
        String consultar = "ConsultarHistorial.jsp";
        String actualizar = "ActualizarHistorial.jsp";
        String registrar = "registrarHistorial.jsp";
        String inicio = "veterinario.jsp";

        if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idHistorial", request.getParameter("id"));
            acceso = actualizar;

        } else if (action.equalsIgnoreCase("Actualizar")) {
            String IdHistorialClinico = request.getParameter("id");
            String Novedad = request.getParameter("novedad");
            historialVo.setIdHistorialClinico(IdHistorialClinico);
            historialVo.setNovedad(Novedad);

            if (dao.Editar(historialVo)) {
                request.setAttribute("error", "<script>alert('Historial NO actualizado!')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('Historial actualizado.')</script>");
            }

            acceso = inicio;
        } else if (action.equalsIgnoreCase("listar")) {
            acceso = consultar;
        } else if (action.equalsIgnoreCase("ListarHistorialUsuario")) {
            acceso = ListarHistoUsuario;
        } else if (action.equalsIgnoreCase("Eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (dao.Eliminar(id)) {
                request.setAttribute("error", "<script>alert('Historial NO eliminado!')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('Historial eliminado correctamente')</script>");
            }
            acceso = consultar;
        } else if (action.equalsIgnoreCase("Agregar")) {
            acceso = registrar;
        } else if (action.equalsIgnoreCase("Registrar")) {

            String fecha = request.getParameter("fecha");
            String novedad = request.getParameter("novedad");
            String servicio = request.getParameter("servicio");
            String mascota = request.getParameter("mascota");
            String usuario = request.getParameter("IdUsuario");

            historialVo.setFecha(fecha);
            historialVo.setNovedad(novedad);
            historialVo.setFKServicio(servicio);
            historialVo.setFKMascota(mascota);
            historialVo.setFKUsuario(usuario);

            if (dao.Agregar(historialVo)) {
                request.setAttribute("error", "<script>alert('Historial NO registrado!')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('Historial registrado')</script>");
               
            }
            acceso = inicio;
        } else {

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
