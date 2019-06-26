<%-- 
    Document   : ConsultarUsuario
    Created on : 1/04/2019, 08:29:04 PM
    Author     : Admin
--%>

<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="Config.Conexion"%>
<%@page import="Config.Conexion"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="VO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/datatables.js" type="text/javascript"></script>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">Listar Usuarios Inhabilitados.!</h1><br>
            <%
                Conexion conexion = new Conexion();
                Statement puente;
                ResultSet rs;
                puente = conexion.obtenerConexion().createStatement();
                rs = puente.executeQuery("select idUsuario,Usuario,Nombres,Apellidos,Telefono,Correo,Rol from usuarios where Estado=0 and Rol='cliente';");
            %>

            <br>
            <form action="Usuario" method="POST">
                <table id="datatable-keytable" class="table table-striped table-bordered">
                    <thead>
                        <tr>
                            <td class="text-center">Cedula</td>
                            <td class="text-center">Usuario</td>
                            <td class="text-center">Nombres</td>
                            <td class="text-center">Apellidos</td>
                            <td class="text-center">Telefono</td>
                            <td class="text-center">Correo</td>
                            <td class="text-center">Rol</td>
                            <td class="text-center">Acciones</td>
                        </tr>                    
                    </thead>
                    <tbody>
                        <%
                            while (rs.next()) {
                        %>
                        <tr>
                            <td class="text-center"><%= rs.getString("idUsuario")%></td>
                            <td class="text-center"><%= rs.getString("Usuario")%></td>
                            <td class="text-center"><%= rs.getString("Nombres")%></td>
                            <td class="text-center"><%= rs.getString("Apellidos")%></td>
                            <td class="text-center"><%= rs.getString("Telefono")%></td>
                            <td class="text-center"><%= rs.getString("Correo")%></td>
                            <td class="text-center"><%= rs.getString("Rol")%></td>
                            <td class="text-center">
                                <a class="btn btn-primary" href="Usuario?accion=EstadoActivo&id=<%= rs.getString("idUsuario")%>&Estado=1">Activar</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </form>
        </div>
        <%if (request.getAttribute("error") != null) {%>
        ${error}
        <%} else {%>
        ${exito}
        <%}%> 
    </body>
    <script>

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
</html>
