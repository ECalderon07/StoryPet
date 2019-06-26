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
    <style>
        label.error{
            color: red;

        }
        input.error{
            border-color: red;
        }
        textarea.error{
            border-color: red;
        }

    </style>
    <body>

        <h1 class="text-center">Consultar Historial</h1>
        <a class="add-proj brd-rd5" href="#" data-toggle="modal" data-target=".bs-example-modal-sm" title="Add Project">+ Agregar</a>
        <br/>
        <br/>
        <%
            HttpSession sesion = request.getSession();
            String cedula = sesion.getAttribute("Cedula").toString();

            Conexion conexion = new Conexion();
            Statement puente;
            ResultSet rs;
            puente = conexion.obtenerConexion().createStatement();
            rs = puente.executeQuery("SELECT historialclinico.idHistorialClinico,historialclinico.Fecha,historialclinico.Novedad,servicios.Servicio,mascotas.Nombre,usuarios.Nombres FROM servicios INNER JOIN historialclinico on servicios.idServicio=historialclinico.FKServicio INNER JOIN mascotas ON historialclinico.FKMascota=mascotas.idMascota INNER JOIN usuarios ON mascotas.FKUsuario=usuarios.idUsuario ;");
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
                        <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Veterinario</td>  
                        <td style="border: 1px;border-bottom-color: #007bff;" class="text-center">Acciones</td>
                    </tr>               

                </thead>
                <tbody>
                    <%
                        while (rs.next()) {
                    %>
                    <tr>
                        <td class="text-center"><%= rs.getString("historialclinico.idHistorialClinico")%></td>                       
                        <td class="text-center"><%= rs.getString("historialclinico.Fecha")%></td>                       
                        <td class="text-center"><%= rs.getString("historialclinico.Novedad")%></td>                       
                        <td class="text-center"><%= rs.getString("servicios.Servicio")%></td>
                        <td class="text-center"><%= rs.getString("mascotas.Nombre")%></td>
                        <td class="text-center"><%= rs.getString("usuarios.Nombres")%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" id="btnEditarH" data-id="<%= rs.getString("historialclinico.idHistorialClinico")%>"><i class="fa fa-pencil"></i> Editar</a>
                            <a class="btn btn-danger btnEliminarH" data-id="<%= rs.getString("historialclinico.idHistorialClinico")%>"><i class="fa fa-trash-o"></i> Eliminar</a>
                        </td>
                    </tr>
                </tbody>
                <%
                    }
                %> 
            </table>
        </form>

        <!-- Modal -->
        <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="text-center"> Registrar Historial</h4>
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body">
                        <form action="Historial" method="POST" class="text-center" id="formRegistrarHistorial" >
                            <label>Fecha</label><br>
                            <input type="text" id="inFecha" readonly name="fecha" ><br><br>
                            <label>Novedad</label><br>
                            <textarea class="form-control" placeholder="Novedad" name="novedad" ></textarea><br>
                            <label>Servicio</label><br>
                            <select name="servicio">
                                <option>Seleccione...</option>
                                <%
                                    ServiciosVo serviciosVo = new ServiciosVo();
                                    ServicioDAO servicioDAO = new ServicioDAO();
                                    List<ServiciosVo> ListarServicio = servicioDAO.Listar();
                                    for (int i = 0; i < ListarServicio.size(); i++) {
                                        serviciosVo = ListarServicio.get(i);

                                %>

                                <option value="<%=serviciosVo.getIdServicio()%>"><%=serviciosVo.getTipoServicio()%></option>
                                <%
                                    }
                                %>
                            </select>


                            <br> 
                            <label>Mascota</label><br>
                            <select name="mascota">
                                <option>Seleccione...</option>
                                <%
                                    MascotasVO mascotasVo = new MascotasVO();
                                    MascotasDAO mascotasDAO = new MascotasDAO();
                                    List<MascotasVO> Lis = mascotasDAO.Listar();
                                    for (int i = 0; i < Lis.size(); i++) {
                                        mascotasVo = Lis.get(i);

                                %>
                                <option value="<%=mascotasVo.getIdMascota()%> "><%=mascotasVo.getNombre()%></option>
                                <%
                                    }
                                %>
                            </select>
                            <br>
                            <label>Usuario</label><br>
                            <input class="bordes" placeholder="Cedula" type="number" value="<%= cedula %>" name="IdUsuario">
                            <br> <br> 
                            <input id="btnRegistrar" class="btn btn-outline-primary" type="submit" name="accion" value="Registrar">
                        </form>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>

        <script>

            $(document).ready(function () {
                var f = new Date();
                var fecha = f.getFullYear() + "/" + (f.getMonth() + 1) + "/" + f.getDate();
                document.getElementById("inFecha").value = fecha;

                $("#formRegistrarHistorial").validate({
                    rules: {
                        novedad: {
                            required: true,
                        },
                        servicio: {
                            required: true,
                        },
                        mascota: {
                            required: true,
                        },
                        IdUsuario: {
                            required: true,
                            number: true,
                            rangelength: [9, 10],
                        },
                    },
                    messages: {
                        novedad: {
                            required: "campo obligatorio",
                        },
                        servicio: {
                            required: "campo obligatorio",
                        },
                        mascota: {
                            required: "campo obligatorio",
                        },
                        idUsuario: {
                            required: "campo obligatorio",
                            number: "ingrese una cedula valida",
                            rangelength: "Debe estar entre 9 a 10 números"
                        },
                    }

                })


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
