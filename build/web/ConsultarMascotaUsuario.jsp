<%-- 
    Document   : ConsultarMascota
    Created on : 05-may-2019, 14:19:55
    Author     : Brayan
--%>

<%@page import="DAO.EspeciesDAO"%>
<%@page import="VO.EspeciesVO"%>
<%@page import="DAO.RazasDAO"%>
<%@page import="VO.RazasVO"%>
<%@page import="java.util.List"%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="VO.UsuarioVO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Config.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="js/jquery.validate.js"></script>
<script src="js/messages_es.js.js"></script>
<script src="js/datatables.js" type="text/javascript"></script>

<style>
    label.error{
        color: red;
    }
</style>


<div class="container">
    <h1 class="text-center">Consultar Mascotas.!</h1><br>
    <br>
    <br>
    <%
        HttpSession sesion = request.getSession();
        String cedula = sesion.getAttribute("Cedula").toString();

        Conexion conexion = new Conexion();
        Statement puente;
        ResultSet rs;
        puente = conexion.obtenerConexion().createStatement();
        rs = puente.executeQuery("SELECT idMascota,mascotas.Nombre, FechaNacimiento, Sexo, razas.raza, FKUsuario FROM razas  INNER JOIN mascotas ON razas.id= mascotas.FKRaza INNER JOIN usuarios ON mascotas.FKUsuario = usuarios.IdUsuario where usuarios.IdUsuario='" + cedula + "';");
    %>


    <form action="Mascota" method="POST">
        <table id="datatable-keytable" class="table table-striped table-bordered" style="width: 100%;">
            <thead>
                <tr>
                    <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Nombre</td>
                    <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Fecha</td>
                    <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Sexo</td>
                    <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Raza</td>                                        
                </tr>   
            </thead>
            <tbody>
                <%
                    while (rs.next()) {
                %>
                <tr>
                    <td class="text-center"><%= rs.getString("mascotas.Nombre")%></td>
                    <td class="text-center"><%= rs.getString("FechaNacimiento")%></td>                        
                    <td class="text-center"><%= rs.getString("Sexo")%></td>                        
                    <td class="text-center"><%= rs.getString("razas.raza")%></td>                        
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </form>
</div>

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
        }
    });

    $(document).ready(function () {
        $("#formRegistrarMascota").validate({
            rules: {
                nombre: {
                    required: true,
                },
                fechaNacimiento: {
                    required: true,
                },
                sexo: {
                    required: true,
                },
                especie: {
                    required: true,
                },
                idRaza: {
                    required: true,
                },
                idUsuario: {
                    required: true,
                }
            }

        })

    });

</script>




<%if (request.getAttribute("error") != null) {%>
${error}
<%} else {%>
${exito}
<%}%> 
