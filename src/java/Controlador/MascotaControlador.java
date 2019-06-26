/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.MascotasDAO;
import VO.MascotasVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "MascotaControlador", urlPatterns = {"/Mascota"})
public class MascotaControlador extends HttpServlet {

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
        String acceso = "";
        String Regis = "registrarMascota.jsp";
        String List = "ConsultarMascota.jsp";
        String ListadoUsuarioMascota = "ConsultarMascotaUsuario.jsp";
        String Editar = "actualizarMascota.jsp";
        String inicio = "veterinario.jsp";

        MascotasVO mascotaVO = new MascotasVO();
        MascotasDAO mascotasDAO = new MascotasDAO();

        if (action.equalsIgnoreCase("Registrar")) {

            String Nombre = request.getParameter("nombre");
            String FechaNacimiento = request.getParameter("fechaNacimiento");
            String Sexo = request.getParameter("sexo");
            String FkEspecies = request.getParameter("FkEspecies");
            String FkRaza = request.getParameter("fkRaza");
            String FkUsuario = request.getParameter("fkUsuario");

            mascotaVO.setNombre(Nombre);
            mascotaVO.setFechaNacimiento(FechaNacimiento);
            mascotaVO.setSexo(Sexo);
            mascotaVO.setFKEspecies(FkEspecies);
            mascotaVO.setFKRaza(FkRaza);
            mascotaVO.setFKUsuario(FkUsuario);

            if (mascotasDAO.Agregar(mascotaVO)) {
                request.setAttribute("error", "<script>alert('La mascota no fue registrada')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('La mascota fue registrada correctamente')</script>");

            }
            acceso = inicio;
        } else if (action.equalsIgnoreCase("Listar")) {
            acceso = List;
        } else if (action.equalsIgnoreCase("ListarMascotaUsuario")) {
            acceso = ListadoUsuarioMascota;
        } else if (action.equalsIgnoreCase("Eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));

            if (mascotasDAO.Eliminar(id)) {
                request.setAttribute("erro", "<script>alert('La mascota fue eliminada correctamente')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('La mascota fue eliminada correctamente')</script>");

            }
            acceso = List;
        } else if (action.equalsIgnoreCase("Editar")) {
            request.setAttribute("idMascota", request.getParameter("id"));
            acceso = Editar;
        } else if (action.equalsIgnoreCase("Actualizar")) {

            String idMascota = request.getParameter("id");
            String Nombre = request.getParameter("nombre");


            mascotaVO.setIdMascota(idMascota);
            mascotaVO.setNombre(Nombre);


            if (mascotasDAO.Editar(mascotaVO)) {
                request.setAttribute("error", "<script>alert('La mascota no pudo ser actualizada')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('La mascota fue actualizada correctamente')</script>");

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
