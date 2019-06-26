<!DOCTYPE html>
<%@page session="true"%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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

                    // guardamos variables traidas de la session.
                    usuario = sesion.getAttribute("Usuario").toString();
                    nombre = sesion.getAttribute("Nombres").toString();
                    apellido = sesion.getAttribute("Apellidos").toString();
                    telefono = sesion.getAttribute("Telefono").toString();
                    correo = sesion.getAttribute("Correo").toString();
                    rol = sesion.getAttribute("Rol").toString();
                %>

                <!-- page content -->
                <div class="" role="main">
                    <div class="">
                        <div class="page-title">
                            <div class="title_left">
                                <h3>Usuario Perfil</h3>
                            </div>

                            <div class="title_right">
                                <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                                    <div class="input-group">

                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="clearfix">

                        </div>

                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="x_panel">
                                    <div class="x_title">

                                    </div>
                                    <div class="x_content">
                                        <div class="col-md-3 col-sm-3 col-xs-12 profile_left">
                                            <div class="profile_img">
                                                <div id="crop-avatar">
                                                    <!-- Current avatar -->
                                                    <img class="img-responsive avatar-view" src="images/picture.jpg" alt="Avatar" title="Change the avatar">
                                                </div>
                                            </div>
                                            <h3><%= nombre + " " + apellido%></h3>

                                            <ul class="list-unstyled user_data">                              
                                                <li>
                                                    <i class="fa fa-briefcase user-profile-icon"></i> <%= rol%>
                                                </li>

                                            </ul>

                                            <br />

                                        </div>
                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                            <!-- start of user-activity-graph -->
                                            <div id="graph_bar" style="width:100%; height:280px;">

                                                <label>Nombres</label>
                                                <label><%= nombre%></label><br/>
                                                <label>Apellidos</label>
                                                <label><%= apellido%></label><br/>
                                                <label>Correo</label>
                                                <label> <%= correo%></label><br/>
                                                <label>Telefono</label>
                                                <label><%= telefono%></label><br/>



                                            </div>
                                            <!-- end of user-activity-graph -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /page content -->

            </div>

    </body>
</html>