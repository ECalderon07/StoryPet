<!DOCTYPE html>
<%@page session="true"%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Validaciones -->        
        <script src="js/jquery.validate.js" type="text/javascript"></script>
        <script src="js/messages_es.js.js" type="text/javascript"></script>
    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">

                <%
                    //recojemos sesion.
                    HttpSession sesion = request.getSession();
                    //creamos variables                            
                    String usuario;
                    String nombre;
                    String apellido;
                    String telefono;
                    String correo;
                    String rol;
                    String cedula;

                    // guardamos variables traidas de la session.
                    usuario = sesion.getAttribute("Usuario").toString();
                    nombre = sesion.getAttribute("Nombres").toString();
                    apellido = sesion.getAttribute("Apellidos").toString();
                    telefono = sesion.getAttribute("Telefono").toString();
                    correo = sesion.getAttribute("Correo").toString();
                    rol = sesion.getAttribute("Rol").toString();
                    cedula = sesion.getAttribute("Cedula").toString();
                %>

                <!-- page content -->
                <div class="" role="main">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_content">                                     
                                <div class="col-md-9 col-sm-9 col-xs-12">
                                    <!-- start of user-activity-graph -->
                                    <div id="graph_bar" style="width:100%; height:280px;">
                                        <div class="container">
                                            <form action="Usuario" method="post" class="cambiarClave" >
                                                <h2>Cambia la Contraseña</h2> 
                                                <hr>                    
                                                Nueva Contraseña<br>
                                                <input type="number" id="claveNueva" name="claveNueva"><br>
                                                Confirmar Contraseña<br>
                                                <input type="number" name="confirmacion"><br><br>
                                                <input type="hidden" name="cedula" value="<%= cedula%>">
                                                <input class="btn btn-default submit btnIngresar text-center" type="submit" name="accion" value="ActualizarContra">
                                                <br>
                                            </form>
                                            <h2>Cambie el nombre de usuario</h2> 
                                            <hr>

                                            <button class="btn btn-default" data-toggle="collapse" data-target="#demo">Cambiar nombre de usuario</button>

                                            <div id="demo" class="collapse">
                                                <input value="<%= nombre%>" type="text" name="nombreNuevo">
                                            </div>                   

                                        </div>
                                        <!-- end of user-activity-graph -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- /page content -->

                </div>

                <script>

                    $(document).ready(function () {

                        $.validator.addMethod('claveNueva', function (value) {
                            return /[0-9a-zA-Z]$/.test(value);
                        }, 'Ingrese una contraseña alfanumérica');


                        $("#cambiarClave").validate({
                            rules: {
                                claveNueva: {
                                    required: true,
                                    contraseña: true,
                                },
                                confirmacion: {
                                    required: true,
                                    contraseña: true,
                                    equalTo: "#claveNueva"
                                },

                            }


                        })



                    });



                </script>


                </body>
                </html>