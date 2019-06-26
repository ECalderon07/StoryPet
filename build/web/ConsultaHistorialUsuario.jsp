<%-- 
    Document   : ConsultarHistorial
    Created on : 19/03/2019, 10:00:50 PM
    Author     : Daniel
--%>

<%@page import="DAO.UsuarioDAO"%>
<%@page import="VO.UsuarioVO"%>
<%@page import="DAO.ServicioDAO"%>
<%@page import="VO.ServiciosVo"%>
<%@page import="DAO.MascotasDAO"%>
<%@page import="VO.MascotasVO"%>
<%@page import="VO.HistorialVo"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Config.Conexion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.HistorialDao"%>
<%@page session="true"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultar Historial</title>   
        <script src="js/jquery.validate.js"></script>
        <script src="js/messages_es.js.js"></script>
        <script src="js/datatables.js" type="text/javascript"></script>
    </head>
    <body>

        <h1 class="text-center">Consultar Historial</h1>
        <br/>
        <br/>
        <%

            HttpSession sesion = request.getSession();
            String cedula = sesion.getAttribute("Cedula").toString();

            Conexion conexion = new Conexion();
            Statement puente;
            ResultSet rs;
            puente = conexion.obtenerConexion().createStatement();
            rs = puente.executeQuery("SELECT historialclinico.idHistorialClinico,historialclinico.Fecha,historialclinico.Novedad,servicios.Servicio,mascotas.Nombre,usuarios.Nombres FROM servicios INNER JOIN historialclinico on servicios.idServicio=historialclinico.FKServicio INNER JOIN mascotas ON historialclinico.FKMascota=mascotas.idMascota INNER JOIN usuarios ON mascotas.FKUsuario=usuarios.idUsuario where idUsuario='" + cedula + "' ;");
        %>

        <form action="Historial"method="POST">
            <table id="datatable-keytable" class="table table-striped table-bordered" style="width: 100%;">
                <thead>
                    <tr>
                        <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">ID</td>
                        <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Fecha</td>
                        <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Novedad</td>
                        <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Servicio</td>
                        <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Mascota</td>  
                        <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Usuario</td>  
                    </tr>               

                </thead>

                <%
                    while (rs.next()) {
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= rs.getString("historialclinico.idHistorialClinico")%></td>                       
                        <td class="text-center"><%= rs.getString("historialclinico.Fecha")%></td>                       
                        <td class="text-center"><%= rs.getString("historialclinico.Novedad")%></td>                       
                        <td class="text-center"><%= rs.getString("servicios.Servicio")%></td>
                        <td class="text-center"><%= rs.getString("mascotas.Nombre")%></td>
                        <td class="text-center"><%= rs.getString("usuarios.Nombres")%></td>    
                    </tr>
                </tbody>
                <%
                    }
                %> 
            </table>
        </form>

        <script>

            $(document).ready(function () {
                var f = new Date();
                var fecha = f.getFullYear() + "/" + (f.getMonth() + 1) + "/" + f.getDate();
                document.getElementById("inFecha").value = fecha;
            });

            $('#datatable-keytable').DataTable({
                language: {
                    "decimal": "",
                    "emptyTable": "No hay información",
                    "info": "Mostrando _START_ a _END_ de _TOTAL_ Entradas",
                    "infoEmpty": "Mostrando 0 to 0 of 0 Entradas",
                    "infoFiltered": "(Filtrado de _MAX_ total entradas)",
                    "infoPostFix": "",
                    "thousands": ",",
                    "lengthMenu": "Mostrar _MENU_ Entradas",
                    "loadingRecords": "Cargando...",
                    "processing": "Procesando...",
                    "search": "Buscar:",
                    "zeroRecords": "Sin resultados encontrados",
                    "paginate": {
                        "first": "Primero",
                        "last": "Ultimo",
                        "next": "Siguiente",
                        "previous": "Anterior"
                    }
                },
            });

        </script>

        <%if (request.getAttribute("error") != null) {%>
        ${error}
        <%} else {%>
        ${exito}
        <%}%> 
    </body>
</html>
