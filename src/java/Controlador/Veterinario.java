/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.HistorialDao;
import DAO.MascotasDAO;
import DAO.ServicioDAO;
import DAO.UsuarioDAO;
import VO.HistorialVo;
import VO.MascotasVO;
import VO.ServiciosVo;
import VO.UsuarioVO;
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
@WebServlet(name = "Veterinario", urlPatterns = {"/Veterinario"})
public class Veterinario extends HttpServlet {

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
        String ActualizarVet = "actualizarUsuarioVeterinario.jsp";
        String consulta = "ListarVeterinarios.jsp";
        String inicio = "administrador.jsp";
        String listarInhabilitadosVeterinario = "UsuariosOcultosVeterinario.jsp";
        String listServicio = "ConsultarServicioVeterinario.jsp";
        String actualizarHisto = "ActualizarHistorialVeterinario.jsp";
        String ListMascota = "consultarMascotaVeterinario.jsp";
        String consultarHisto = "ConsultarHistorialVeterinario.jsp";
        String EditarMascota = "actualizarMascotaVeterinario.jsp";
        String EditarServicio= "actualizarServicioVeterinario.jsp";
        
        
        UsuarioVO usuario = new UsuarioVO();
        UsuarioDAO DAO = new UsuarioDAO();
        ServiciosVo servicioVO = new ServiciosVo();
        ServicioDAO servicioDAO = new ServicioDAO();
        HistorialVo historialVo = new HistorialVo();
        HistorialDao dao = new HistorialDao();
        MascotasVO mascotaVO = new MascotasVO();
        MascotasDAO mascotasDAO = new MascotasDAO();

        if (action.equalsIgnoreCase("RegistrarVeterinario")) {

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

        } else if (action.equalsIgnoreCase("listarInhabilitadosVeterinario")) {
            acceso = listarInhabilitadosVeterinario;
        } else if (action.equalsIgnoreCase("listarVeterinario")) {
            acceso = consulta;
        } else if (action.equalsIgnoreCase("EditarVeterinario")) {
            //recojemos parametro id & manda mos parametro idUsuario a la vista actualizar
            request.setAttribute("idUsuario", request.getParameter("id"));
            acceso = ActualizarVet;
        } else if (action.equalsIgnoreCase("ActualizarVeterinario")) {

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

        } else if (action.equalsIgnoreCase("EliminarVeterinario")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (DAO.EliminarRegistro(id)) {
                request.setAttribute("error", "<script>alert('El Usuario no fue Eliminado')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('El Usuario fue Eliminado correctamente')</script>");
            }
            acceso = consulta;
        } else if (action.equalsIgnoreCase("EstadoVetActivar")) {

            int id = Integer.parseInt(request.getParameter("id"));
            int Estado = Integer.parseInt(request.getParameter("Estado"));

            if (DAO.Estado(Estado, id)) {
                request.setAttribute("error", "<script>alert('no es posible inhabilitar el usuario')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('Usuario habilitado')</script>");
            }
            acceso = inicio;

        } else if (action.equalsIgnoreCase("EstadoVet")) {

            int id = Integer.parseInt(request.getParameter("id"));
            int Estado = Integer.parseInt(request.getParameter("Estado"));

            if (DAO.Estado(Estado, id)) {
                request.setAttribute("error", "<script>alert('no es posible inhabilitar el usuario')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('Usuario inhabilitado')</script>");
            }
            acceso = inicio;

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

        } else if (action.equalsIgnoreCase("Eliminar")) {
            int id = Integer.parseInt(request.getParameter("idServicio"));
            if (servicioDAO.EliminarRegistro(id)) {
                request.setAttribute("error", "<script> alert('Error en la eliminacion') </script>");
            } else {
                request.setAttribute("exito", "<script> alert('Servicio eliminado') </script>");
            }
            acceso = listServicio;

        } else if (action.equalsIgnoreCase("Registrar")) {
            String Servicio = request.getParameter("txtServicio");
            servicioVO.setTipoServicio(Servicio);
            if (servicioDAO.AgregarRegistro(servicioVO)) {
                request.setAttribute("error", "<script> alert('Error en el registro') </script>");
            } else {
                request.setAttribute("exito", "<script> alert('Servicio registrado') </script>");
            }
            acceso = inicio;

        } else if (action.equalsIgnoreCase("editarHistorial")) {
            request.setAttribute("idHistorial", request.getParameter("id"));
            acceso = actualizarHisto;

        } else if (action.equalsIgnoreCase("ActualizarH")) {
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
        } else if (action.equalsIgnoreCase("RegistrarH")) {

            String fecha = request.getParameter("fecha");
            String novedad = request.getParameter("novedad");
            String servicio = request.getParameter("servicio");
            String mascota = request.getParameter("mascota");
            String usuarioH = request.getParameter("IdUsuario");

            historialVo.setFecha(fecha);
            historialVo.setNovedad(novedad);
            historialVo.setFKServicio(servicio);
            historialVo.setFKMascota(mascota);
            historialVo.setFKUsuario(usuarioH);

            if (dao.Agregar(historialVo)) {
                request.setAttribute("error", "<script>alert('Historial NO registrado!')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('Historial registrado')</script>");
            }
            acceso = inicio;
        } else if (action.equalsIgnoreCase("EliminarH")) {
            int id = Integer.parseInt(request.getParameter("id"));
            if (dao.Eliminar(id)) {
                request.setAttribute("error", "<script>alert('Historial NO eliminado!')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('Historial eliminado correctamente')</script>");
            }
            acceso = consultarHisto;
        } else if (action.equalsIgnoreCase("ListarM")) {
            acceso = ListMascota;
        } else if (action.equalsIgnoreCase("listarH")) {
            acceso = consultarHisto;
        } else if (action.equalsIgnoreCase("listarS")) {
            acceso = listServicio;
        } else if (action.equalsIgnoreCase("ActualizarM")) {
            String idMascota = request.getParameter("idMascota");
            String Nombre = request.getParameter("nombre");
            String FechaNacimiento = request.getParameter("fechaNacimiento");
            String Sexo = request.getParameter("sexo");
            String raza = request.getParameter("fkRaza");
            String usuarioM = request.getParameter("fkUsuario");

            mascotaVO.setIdMascota(idMascota);
            mascotaVO.setNombre(Nombre);
            mascotaVO.setFechaNacimiento(FechaNacimiento);
            mascotaVO.setSexo(Sexo);
            mascotaVO.setFKRaza(raza);
            mascotaVO.setFKUsuario(usuarioM);
            if (mascotasDAO.Editar(mascotaVO)) {
                request.setAttribute("error", "<script>alert('La mascota fue actualizada correctamente')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('La mascota no pudo ser actualizada')</script>");
            }
            acceso = inicio;
        } else if (action.equalsIgnoreCase("RegistrarM")) {
            String Nombre = request.getParameter("nombre");
            String FechaNacimiento = request.getParameter("fechaNacimiento");
            String Sexo = request.getParameter("sexo");
            String IdRaza = request.getParameter("idRaza");
            String IdUsuario = request.getParameter("idUsuario");

            mascotaVO.setNombre(Nombre);
            mascotaVO.setFechaNacimiento(FechaNacimiento);
            mascotaVO.setSexo(Sexo);
            mascotaVO.setFKRaza(IdRaza);
            mascotaVO.setFKUsuario(IdUsuario);
            if (mascotasDAO.Agregar(mascotaVO)) {
                request.setAttribute("error", "<script>alert('La mascota no fue registrada')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('La mascota fue registrada correctamente')</script>");
            }
            acceso = inicio;
        } else if (action.equalsIgnoreCase("EliminarM")) {
            int id = Integer.parseInt(request.getParameter("id"));

            if (mascotasDAO.Eliminar(id)) {
                request.setAttribute("erro", "<script>alert('La mascota fue eliminada correctamente')</script>");
            } else {
                request.setAttribute("exito", "<script>alert('La mascota fue eliminada correctamente')</script>");
            }
            acceso = ListMascota;
        } else if (action.equalsIgnoreCase("EditarMascota")) {
            request.setAttribute("idMascota", request.getParameter("id"));
            acceso = EditarMascota;
        } else if (action.equalsIgnoreCase("Editar")) {
            request.setAttribute("idServicio", request.getParameter("idServicio"));
            acceso = EditarServicio;
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
