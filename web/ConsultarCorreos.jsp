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
                        <h4 class="text-center"> Agregar Correo</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form class="form-horizontal" action="Mail" method="post">
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="">Destinatario:</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" name="Destinatario" id="Destinatario" placeholder="Enter email">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="">Asunto:</label>
                                <div class="col-sm-10"> 
                                    <input type="text" class="form-control" name="Asunto" id="Asunto" placeholder="Enter password">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-2" for="">Mensaje:</label>
                                <div class="col-sm-10">
                                    <textarea rows="4" cols="50" name="Mensaje" id="Mensaje" style="width:100%">
                        
                                    </textarea>

                                </div>
                            </div>
                            <div class="form-group"> 
                                <div class="col-sm-offset-2 col-sm-10">
                                    <button type="submit" class="btn btn-default">Submit</button>
                                    <span class="message">${message}</span>
                                </div>
                            </div>
                        </form>
                    </div>


                </div>
            </div>
        </div>


    </body>
    <script src="js/validacion.js"></script>
    <script src="js/jquery-3.3.1.min.js"></script>
</html>
