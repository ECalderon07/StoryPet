<%-- 
    Document   : actualizarUsuario
    Created on : 1/04/2019, 09:44:46 PM
    Author     : Admin
--%>
<%@page import="DAO.UsuarioDAO"%>
<%@page import="VO.UsuarioVO"%>
<%@page import="VO.UsuarioVO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/jquery.validate.js" ></script>
        <script src="js/messages_es.js.js"></script>
    </head>
    <body>
        <div class="container">   
            <div class="col-lg-6">
                <%
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    String id = request.getAttribute("idUsuario").toString();
                    UsuarioVO usuarioVO = (UsuarioVO) usuarioDAO.ListarId(id);

                %>
                <form action="Usuario" method="POST" id="formActualizarUsuario">
                    <h1>Actualizar Usuario!</h1>
                    <label>Cedula</label><br>
                    <input class="form-control" readonly="readonly" type="text" name="id" value="<%=usuarioVO.getIdUsuario()%>"><br>
                    <label>Usuario</label><br>
                    <input class="form-control" type="text" id="usuario" name="usuario" value="<%=usuarioVO.getUsuario()%>"><br>
                    <label>Nombres</label><br>
                    <input class="form-control" type="text" id="nombres" name="nombres" value="<%=usuarioVO.getNombres()%>"><br>
                    <label>Apellidos</label><br>
                    <input class="form-control" type="text" id="apellidos" name="apellidos" value="<%=usuarioVO.getApellidos()%>"><br>
                    <label>Telefono</label><br>
                    <input class="form-control" type="text" id="telefono" name="telefono" value="<%=usuarioVO.getTelefono()%>"><br>
                    <label>Correo</label><br>
                    <input class="form-control" type="email" id="correo" name="correo" value="<%=usuarioVO.getCorreo()%>"><br>
                    <label>Rol</label><br>
                    <input class="form-control" type="text" id="rol" name="rol" value="<%=usuarioVO.getRol()%>"><br>    
                    <input id="btnActualizar" class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                </form>
            </div>
        </div>                    



        <script>
            $(document).ready(function () {

                //           $("#btnActualizar").click(function () {
                //             let formulario = $("form").serialize()
                //           console.log(formulario)
                //            console.log("Editar Usuario: " + id)
                //            $.ajax({
                //                url: 'Usuario',
                //                method: 'POST',
                //                data: {'accion': 'Actualizar', 'formulario': formulario},
                //                success: function (respuesta) {
                //                    alert('Usuario Actualizado')
                //                },
                //                error: function () {
                //                    alert("No se ha podido actualizar el usuario");
                //               }
                //           })
                //       })

                $("#formActualizarUsuario").validate({
                    rules: {
                        telefono: {
                            required: true,
                            number: true,
                            rangelength: [7, 10]
                        },
                    },
                    messages: {
                        telefono: {
                            required: "Campo obligatorio",
                            number: "Campo númerico",
                            rangelength: "Debe estar entre 7 a 10 dígitos"
                        },
                    }
                })
                ,
            })
        </script>

        <%if (request.getAttribute("error") != null) {%>
        ${error}
        <%} else {%>
        ${exito}
        <%}%> 

    </body>
</html>
