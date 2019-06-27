<%-- 
    Document   : ConsultarCorreos
    Created on : Jun 23, 2019, 6:21:56 PM
    Author     : Edwin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Config.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

    </head>
    <style>
        .buscar{
            display: flex;

        }
        .form{
            display: flex;
            padding-left: 800px;
        }
    </style>
    <body>
        <h1 class="text-center">Consultar Correos</h1>
        <%
            HttpSession miSesion = request.getSession();
            String cedula;

            Conexion conexion = new Conexion();
            Statement puente;
            ResultSet rs;
            puente = conexion.obtenerConexion().createStatement();
            rs = puente.executeQuery("SELECT Destinatario,Asunto,Mensaje,Fecha FROM correo ;");

        %>

        <a class="add-proj brd-rd5" href="#" data-toggle="modal" data-target=".bs-example-modal-sm" title="Add Project">+ Agregar</a>


        <div class="container">
            <form action="Historial">
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <td class="text-center">Destinatario</td>
                            <td class="text-center">Asunto</td>
                            <td class="text-center">Mensaje</td>
                            <td class="text-center">Fecha</td>
                        </tr>               

                    </thead>

                    <%                        while (rs.next()) {
                    %>
                    <tbody>
                        <tr>
                            <td class="text-center"><%= rs.getString("Destinatario")%></td>                       
                            <td class="text-center"><%= rs.getString("Asunto")%></td>
                            <td class="text-center"><%= rs.getString("Mensaje")%></td>
                            <td class="text-center"><%= rs.getString("Fecha")%></td>
                        </tr>
                    </tbody>
                    <%
                        }
                    %> 
                </table>
                <a class="btn btn-success" href="list.jsp">Volver</a>
            </form>
        </div>

        <!-- Modal -->
        <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="text-center"> Enviar Correo</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form method="POST" action="EmailEnvio">
                            <div class="modal-body mx-3">
                                <div class="md-form mb-5">
                                    <label data-error="wrong" data-success="right" for="orangeForm-name">Destinatario</label>
                                    <input type="email" id="" class="form-control validate" name="destinatario" required>
                                </div>
                                <div class="md-form mb-5">
                                    <label data-error="wrong" data-success="right" for="orangeForm-name">Asunto</label>
                                    <input type="text" id="" class="form-control validate" name="asunto" required>
                                </div>

                                <div class="md-form mb-4">
                                    <label data-error="wrong" data-success="right" for="orangeForm-name">Mensaje</label>
                                    <input type="text" id="" class="form-control validate" name="mensaje" required>
                                </div>

                            </div>

                            <div class="modal-footer d-flex justify-content-center">
                                <button type="submit" class="btn btn-primary">Enviar</button>
                                <span class="message">${message}</span>
                            </div>
                        </form>
                    </div>


                </div>
            </div>
        </div>


    </body>
    <script src="js/validacion.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>

    <script>
        $(document).ready(function () {
            var f = new Date();
            var fecha = f.getFullYear() + "/" + (f.getMonth() + 1) + "/" + f.getDate() + "/" + f.getHours() + "/" + f.getMinutes() + "/" + f.getSeconds();
            document.getElementById("inFecha").value = fecha;
        });
    </script>
</html>
