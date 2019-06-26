<%-- 
    Document   : listar
    Created on : 11/04/2019, 02:28:56 PM
    Author     : Daniel
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Config.Conexion"%>
<%@page import="java.util.Iterator"%>
<%@page import="VO.ServiciosVo"%>
<%@page import="java.util.List"%>
<%@page import="DAO.ServicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">        
        <script src="js/jquery.validate.js" ></script>
        <script src="js/messages_es.js.js"></script>
        <title>Servicios</title>
    </head>
    <style>
        label.error{
            color: red;
        }
    </style>
    <body>           

        <h1 class="text-center">Servicios</h1><hr> 
        <a class="add-proj brd-rd5" href="#" data-toggle="modal" data-target=".bs-example-modal-sm" title="Add Project">+ Agregar</a>
        <br>
        <br>                              

        <%
            Conexion conexion = new Conexion();
            Statement puente;
            ResultSet rs;
            puente = conexion.obtenerConexion().createStatement();
            rs = puente.executeQuery("SELECT IdServicio,Servicio FROM servicios;");
        %>
        <form action="Veterinario" method="POST">
            <table id="datatable-keytable" class="table table-striped table-bordered" style="width: 100%;">
                <thead>
                    <tr>
                        <th style="border: 1px;border-bottom-color: #007bff;" class="text-center">IdServicios</th>
                        <th style="border: 1px;border-bottom-color: #007bff;" class="text-center">Servicio</th>
                        <th style="border: 1px;border-bottom-color: #007bff;" class="text-center">Acciones</th>
                    </tr>
                </thead>                
                <tbody> 
                    <%
                        while (rs.next()) {
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getString("IdServicio")%></td>
                        <td class="text-center"><%= rs.getString("Servicio")%></td>
                        <td class="text-center">
                            <a class="btn btn-warning btnEditarS" data-id="<%= rs.getString("IdServicio")%>"><i class="fa fa-pencil"></i> Editar</a>
                            <a class="btn btn-danger btnEliminarS" data-id="<%= rs.getString("IdServicio")%>"><i class="fa fa-trash-o"></i> Eliminar</a>
                        </td>
                    </tr>  
                    <%
                        }
                    %>
                </tbody>              
            </table>
        </form>

        <!-- Modal -->
        <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="text-center"> Registrar Servicio</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form action="Veterinario" class="text-center" id="formRegistrarServicio">                            
                            Tipo de Servicio:<br>
                            <input class="form-control" type="text" name="txtServicio"><br>
                            <input type="submit" id="btnRegistrar" name="accion" value="Registrar" class="btn btn-outline-primary">                                               
                        </form>
                    </div>=                    
                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <script>

            $(document).ready(function () {

                $("#formRegistrarServicio").validate({
                    rules: {
                        txtServicio: {
                            required: true,
                        },
                    },
                    messages: {
                        required: "campo obligatorio",
                    },

                })



            })

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

        <% if (request.getAttribute("error") != null) {%>
        ${error}
        <%} else {%>
        ${exito}
        <%}%>
    </body>
</html>