/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.UsuarioDAO;
import VO.UsuarioVO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Brayan
 */
@WebServlet(name = "Usuario", urlPatterns = {"/Usuario"})
public class Usuario extends HttpServlet {

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
        String RegistrarVista = "registrarUsuario.jsp";
        String Actualizar = "actualizarUsuario.jsp";
        String ActualizarVet = "actualizarUsuarioVeterinario.jsp";
        String consultar = "ListarUsuario.jsp";
        String consulta2 = "ListarVeterinarios.jsp";
        String consultarVet = "listarVet.jsp";
        String inicio = "veterinario.jsp";
        String perfil = "perfil.jsp";
        String inicio2 = "administrador.jsp";
        String listarInhabilitados = "UsuariosOcultos.jsp";
        String listarInhabilitadosVeterinario = "UsuariosOcultosVeterinario.jsp";
        String config = "configuracion.jsp";
        String VistaCorreo = "ConsultarCorreos.jsp";

        UsuarioVO usuario = new UsuarioVO();
        UsuarioDAO DAO = new UsuarioDAO();

        if (action.equalsIgnoreCase("Registrar")) {

            String idUsuario = request.getParameter("cedula");
            String Usuario = request.getParameter("usuario");
            String Contraseña = request.getParameter("clave");
            String Nombres = request.getParameter("nombres");
            String Apellidos = request.getParameter("apellidos");
            String Telefono = request.getParameter("telefono");
            String Correo = request.getParameter("correo");
            String Rol = request.getParameter("rol");

            usuario.setIdUsuario(idUsuario);
            usuario.setUsuario(Usuario);
            usuario.setContraseña(Contraseña);
            usuario.setNombres(Nombres);
            usuario.setApellidos(Apellidos);
            usuario.setTelefono(Telefono);
            usuario.setCorreo(Correo);
            usuario.setRol(Rol);

            if (DAO.AgregarRegistro(usuario)) {
                request.setAttribute("error", "<script>alert('usuario no registrado')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('usuario registrado Correctamente')</script>");
            }
            acceso = inicio;

        } else if (action.equalsIgnoreCase("add")) {
            acceso = RegistrarVista;
        } else if (action.equalsIgnoreCase("listar")) {
            acceso = consultar;
        } else if (action.equalsIgnoreCase("perfil")) {
            acceso = perfil;
        } else if (action.equalsIgnoreCase("listarInhabilitados")) {
            acceso = listarInhabilitados;
        } else if (action.equalsIgnoreCase("Editar")) {
            //recojemos parametro id & manda mos parametro idUsuario a la vista actualizar
            request.setAttribute("idUsuario", request.getParameter("id"));
            acceso = Actualizar;
        } else if (action.equalsIgnoreCase("Actualizar")) {

            String idUsuario = request.getParameter("id");

            String Usuario = request.getParameter("usuario");
            String Nombres = request.getParameter("nombres");
            String Apellidos = request.getParameter("apellidos");
            String Telefono = request.getParameter("telefono");
            String Correo = request.getParameter("correo");
            String Rol = request.getParameter("rol");

            usuario.setIdUsuario(idUsuario);
            usuario.setUsuario(Usuario);
            usuario.setNombres(Nombres);
            usuario.setApellidos(Apellidos);
            usuario.setTelefono(Telefono);
            usuario.setCorreo(Correo);
            usuario.setRol(Rol);

            if (DAO.ActualizarRegistro(usuario)) {
                request.setAttribute("error", "<script>alert('usuario no actualizado')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('Usuario actualizado correctamente')</script>");
            }
            acceso = inicio;
        } else if (action.equalsIgnoreCase("Eliminar")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (DAO.EliminarRegistro(id)) {
                request.setAttribute("error", "<script>alert('El Usuario no fue Eliminado')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('El Usuario fue Eliminado correctamente')</script>");
            }
            acceso = consultar;
        } else if (action.equalsIgnoreCase("Estado")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int Estado = Integer.parseInt(request.getParameter("Estado"));

            if (DAO.Estado(Estado, id)) {
                request.setAttribute("error", "<script>alert('no es posible inhabilitar el usuario')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('Usuario inhabilitado')</script>");
            }
            acceso = inicio;

        } else if (action.equalsIgnoreCase("EstadoActivo")) {
            int id = Integer.parseInt(request.getParameter("id"));
            int Estado = Integer.parseInt(request.getParameter("Estado"));

            if (DAO.Estado(Estado, id)) {
                request.setAttribute("error", "<script>alert('No es posible habilitar usuario')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('usuario habilitado')</script>");

            }
            acceso = inicio;

        } else if (action.equalsIgnoreCase("ingresar")) {

            String Correo = request.getParameter("correo");
            String Clave = request.getParameter("clave");
            String Rol;

            usuario.setCorreo(Correo);
            usuario.setContraseña(Clave);

            usuario = DAO.autenticarUsuario(usuario);
            Rol = usuario.getRol();

            if (Rol.equals("admin")) {
                HttpSession Sesion = request.getSession();
                Sesion.setAttribute("Cedula", usuario.getIdUsuario());
                Sesion.setAttribute("Correo", Correo);
                Sesion.setAttribute("Usuario", usuario.getUsuario());
                Sesion.setAttribute("Nombres", usuario.getNombres());
                Sesion.setAttribute("Apellidos", usuario.getApellidos());
                Sesion.setAttribute("Telefono", usuario.getTelefono());
                Sesion.setAttribute("Correo", usuario.getCorreo());
                Sesion.setAttribute("Rol", usuario.getRol());

                request.getRequestDispatcher("administrador.jsp").forward(request, response);
                return;

            } else if (Rol.equals("cliente")) {
                HttpSession Sesion = request.getSession();
                Sesion.setAttribute("Cedula", usuario.getIdUsuario());
                Sesion.setAttribute("Correo", Correo);
                Sesion.setAttribute("Usuario", usuario.getUsuario());
                Sesion.setAttribute("Nombres", usuario.getNombres());
                Sesion.setAttribute("Apellidos", usuario.getApellidos());
                Sesion.setAttribute("Telefono", usuario.getTelefono());
                Sesion.setAttribute("Correo", usuario.getCorreo());
                Sesion.setAttribute("Rol", usuario.getRol());

                request.getRequestDispatcher("cliente.jsp").forward(request, response);
                return;

            } else if (Rol.equals("veterinario")) {
                HttpSession Sesion = request.getSession();
                Sesion.setAttribute("Cedula", usuario.getIdUsuario());
                Sesion.setAttribute("Correo", usuario.getCorreo());
                Sesion.setAttribute("Usuario", usuario.getUsuario());
                Sesion.setAttribute("Nombres", usuario.getNombres());
                Sesion.setAttribute("Apellidos", usuario.getApellidos());
                Sesion.setAttribute("Telefono", usuario.getTelefono());
                Sesion.setAttribute("Correo", usuario.getCorreo());
                Sesion.setAttribute("Rol", usuario.getRol());

                //  request.getRequestDispatcher("InicioAdmin.jsp").forward(request, response);
                request.getRequestDispatcher("veterinario.jsp").forward(request, response);
                return;

            } else if (Rol == null) {
                request.getRequestDispatcher("login.jsp").forward(request, response);
                request.setAttribute("error", "<script>alert('Usuario o Contraseña Invalida)</script>");
            }
        } else if (action.equalsIgnoreCase("config")) {
            acceso = config;
        } else if (action.equalsIgnoreCase("ActualizarContra")) {

            String claveNueva = request.getParameter("claveNueva");
            String cedula = request.getParameter("cedula");

            usuario.setIdUsuario(cedula);
            usuario.setContraseña(claveNueva);

            if (DAO.CambiarContra(usuario)) {
                request.setAttribute("error", "<script>alert('No es posible actualizar contraseña')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('contraseña actualizada')</script>");
            }
            acceso = inicio;
        } else if (action.equalsIgnoreCase("CorreoVista")) {
            acceso = VistaCorreo;
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
