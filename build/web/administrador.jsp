<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>StoryPet! | </title>

        <!-- Datatables -->
        <link href="./vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
        <link href="./vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
        <link href="./vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
        <!-- Bootstrap -->
        <link href="./vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="./vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="./vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- bootstrap-progressbar -->
        <link href="./vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
        <!-- bootstrap-daterangepicker -->
        <link href="./vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">
        <!-- Tabla -->
        <script src="js/datatables.js" type="text/javascript"></script>
        <!-- Custom Theme Style -->
        <link href="./build/css/custom.min.css" rel="stylesheet">

        <script src="js/jquery.validate.js"></script>
        <script src="js/messages_es.js.js"></script>

    </head>

    <body class="nav-md">
        <div class="container body">
            <div class="main_container">
                <div class="col-md-3 left_col">
                    <div class="left_col scroll-view">
                        <div class="navbar nav_title" style="border: 0;">
                            <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>StoryPet!</span></a>
                        </div>

                        <div class="clearfix"></div>
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

                            //validamos correo
                            if (sesion.getAttribute("Correo") != null) {
                        %>
                        <!-- menu profile quick info -->
                        <div class="profile clearfix">
                            <div class="profile_pic">
                                <img src="images/man.png" alt="..." class="img-circle profile_img">
                            </div>
                            <div class="profile_info">
                                <span>Bienvenido,</span>
                                <h2><%= nombre%></h2>
                            </div>
                        </div>
                        <%
                            } else {
                                out.print("<script>alert('inicie sesion');</script>");
                                out.print("<script>location.replace('index.jsp');</script>");
                            }
                        %>
                        <!-- /menu profile quick info -->

                        <br />

                        <!-- sidebar menu -->
                        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
                            <div class="menu_section">
                                <h3>General</h3>
                                <ul class="nav side-menu">
                                    <li><a id="btnClientes"><i  class="fa fa-home"></i> Clientes</a>
                                    </li>
                                    <li> <a id="btnMascotas"><i class="fa fa-edit"></i> Mascotas </a></li>
                                    <li><a id="btnHistorial"><i class="fa fa-desktop"></i> Historial </a>
                                    </li>
                                    <li><a id="btnServicios"><i class="fa fa-table"></i> Servicios </a>
                                    </li>
                                    <li><a id="btninhabilitados"><i class="fa fa-bar-chart-o"></i> Inhabilitados</a>
                                    </li>      
                                </ul>
                            </div>
                        </div>
                        <!-- /sidebar menu -->


                        <!-- /menu footer buttons -->
                        <div class="sidebar-footer hidden-small">
                            <a data-toggle="tooltip" data-placement="top" title="Settings">
                                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
                            </a>
                            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
                            </a>
                            <a data-toggle="tooltip" data-placement="top" title="Lock">
                                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
                            </a>
                            <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
                            </a>
                        </div>
                        <!-- /menu footer buttons -->
                    </div>
                </div>

                <!-- top navigation -->
                <div class="top_nav">
                    <div class="nav_menu">
                        <nav>
                            <div class="nav toggle">
                                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
                            </div>

                            <ul class="nav navbar-nav navbar-right">
                                <li class="">
                                    <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                                        <img src="images/man.png" alt=""><%= nombre%>
                                        <span class=" fa fa-angle-down"></span>
                                    </a>
                                    <ul class="dropdown-menu dropdown-usermenu pull-right">
                                        <li><a id="btnPerfil"> Perfil</a></li>
                                        <li>
                                            <a href="javascript:;">
                                                <span class="badge bg-red pull-right">50%</span>
                                                <span>Configuracion</span>
                                            </a>
                                        </li>
                                        <li><a href="javascript:;">Ayuda</a></li>

                                        <li>
                                            <%
                                                out.print("<a class='btn-danger' href='index.jsp?cerrar=true'><i class='fa fa-sign-out pull-right'></i> Salir</a>");
                                            %> 
                                        </li>
                                    </ul>
                                </li>

                                <li role="presentation" class="dropdown">
                                    <a href="javascript:;" class="dropdown-toggle info-number" data-toggle="dropdown" aria-expanded="false">
                                        <i class="fa fa-envelope-o"></i>
                                        <span class="badge bg-green">6</span>
                                    </a>
                                    <ul id="menu1" class="dropdown-menu list-unstyled msg_list" role="menu">
                                        <li>
                                            <a>
                                                <span class="image"><img src="images/man.png" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image"><img src="images/img.png" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <a>
                                                <span class="image"><img src="images/img.jpg" alt="Profile Image" /></span>
                                                <span>
                                                    <span>John Smith</span>
                                                    <span class="time">3 mins ago</span>
                                                </span>
                                                <span class="message">
                                                    Film festivals used to be do-or-die moments for movie makers. They were where...
                                                </span>
                                            </a>
                                        </li>
                                        <li>
                                            <div class="text-center">
                                                <a>
                                                    <strong>See All Alerts</strong>
                                                    <i class="fa fa-angle-right"></i>
                                                </a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <!-- /top navigation -->

                <!-- page content -->
                <div class="right_col" role="main">
                    <!-- top tiles -->
                    <div class="row tile_count">
                        <div class="row top_tiles" style="margin: 10px 0;">
                            <div id="contenido_principal">
                            </div>   
                        </div>
                        <!-- /top tiles -->
                    </div>
                    <!-- /page content -->

                </div>
            </div>


            <!-- Custom Theme Scripts -->
            <script src="./build/js/custom.min.js"></script>

            <!-- jQuery -->
            <script src="./vendors/jquery/dist/jquery.min.js"></script>
            <!-- Bootstrap -->
            <script src="./vendors/bootstrap/dist/js/bootstrap.min.js"></script>
            <!-- FastClick -->
            <script src="./vendors/fastclick/lib/fastclick.js"></script>
            <!-- NProgress -->
            <script src="./vendors/nprogress/nprogress.js"></script>
            <!-- Chart.js -->
            <script src="./vendors/Chart.js/dist/Chart.min.js"></script>
            <!-- jQuery Sparklines -->
            <script src="./vendors/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
            <!-- morris.js -->
            <script src="./vendors/raphael/raphael.min.js"></script>
            <script src="./vendors/morris.js/morris.min.js"></script>
            <!-- gauge.js -->
            <script src="./vendors/gauge.js/dist/gauge.min.js"></script>
            <!-- bootstrap-progressbar -->
            <script src="./vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
            <!-- Skycons -->
            <script src="./vendors/skycons/skycons.js"></script>
            <!-- Flot -->
            <script src="./vendors/Flot/jquery.flot.js"></script>
            <script src="./vendors/Flot/jquery.flot.pie.js"></script>
            <script src="./vendors/Flot/jquery.flot.time.js"></script>
            <script src="./vendors/Flot/jquery.flot.stack.js"></script>
            <script src="./vendors/Flot/jquery.flot.resize.js"></script>
            <!-- Flot plugins -->
            <script src="./vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
            <script src="./vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
            <script src="./vendors/flot.curvedlines/curvedLines.js"></script>
            <!-- DateJS -->
            <script src="./vendors/DateJS/build/date.js"></script>
            <!-- bootstrap-daterangepicker -->
            <script src="./vendors/moment/min/moment.min.js"></script>
            <script src="./vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

            <!-- Custom Theme Scripts -->
            <script src="./build/js/custom.min.js"></script>

            <script>
                function activarEditarEliminarUsuario() {
                    $(".btnEditarU").click(function () {
                        alert('btnEditarU');
                        var id = $(this).attr("data-id");
                        console.log("Editar Usuario: " + id);
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'EditarVeterinario', 'id': id},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarUsuario();
                            },
                            error: function () {
                                alert("No se ha podido editar");
                            }
                        });
                    });

                    $(".btnEliminarU").click(function () {
                        alert('btnEliminarU');
                        var id = $(this).attr("data-id");
                        console.log("Eliminar Usuario: " + id);
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'EliminarVeterinario', 'id': id},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarUsuario();
                            },
                            error: function () {
                                alert("No se ha podido eliminar");
                            }
                        });
                    });

                }

                function activarEditarEliminarServicio() {
                    $(".btnEditarS").click(function () {
                        alert('EditarServicio');
                        var id = $(this).attr("data-id");
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'Editar', 'idServicio': id},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarServicio();
                            },
                            error: function () {
                                alert("No se ha podido editar");
                            }
                        });
                    });

                    $(".btnEliminarS").click(function () {
                        alert('EliminarServicio');
                        var id = $(this).attr("data-id");
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'Eliminar', 'idServicio': id},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                // activarEditarEliminarServicio()
                            },
                            error: function () {
                                alert("No se ha podido editar");
                            }
                        });
                    });
                }

                function activarEditarEliminarMascota() {
                    $(".btnEditarM").click(function () {
                        alert("editarMascota");
                        var id = $(this).attr("data-id");
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'EditarMascota', 'id': id},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarMascota();
                            },
                            error: function () {
                                alert("Error al editar");
                            }
                        });
                    });

                    $("#btnEliminarM").click(function () {
                        alert("eliminarrMascota");
                        var id = $(this).attr("data-id");
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'EliminarM', 'id': id},
                            succes: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarMascota();
                            },
                            error: function () {
                                alert("Error al eliminar");
                            }
                        });
                    });

                }

                function activarEditarEliminarHistorial() {
                    $(".btnEditarH").click(function () {
                        alert("editar historial");
                        var id = $(this).attr("data-id");
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'editarHistorial', 'id': id},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarUsuario();
                            },
                            error: function () {
                                alert("No se ha podido editar");
                            }
                        });
                    });

                    $(".btnEliminarH").click(function () {
                        alert("eliminarHistorial");
                        var id = $(this).attr("data-id");
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'EliminarH', 'id': id},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarMascota();
                            },
                            error: function () {
                                alert("Error al eliminar");
                            }
                        });
                    });

                }

                $(document).ready(function () {
                    activarEditarEliminarMascota();
                    activarEditarEliminarUsuario();
                    activarEditarEliminarHistorial();
                    activarEditarEliminarServicio();

                    $.ajax({
                        url: 'Veterinario',
                        method: 'POST',
                        data: {'accion': 'listarVeterinario'},
                        success: function (respuesta) {
                            $("#contenido_principal").html(respuesta);
                            activarEditarEliminarUsuario();
                        },
                        error: function () {
                            alert("No se ha podido obtener la información");
                        }
                    });


                    $("#btnClientes").click(function () {
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'listarVeterinario'},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarUsuario();
                            },
                            error: function () {
                                alert("No se ha podido obtener la información");
                            }
                        });
                    });


                    $("#btnServicios").click(function () {
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'listarS'},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarServicio();
                            },
                            error: function () {
                                alert("No se ha podido obtener la información");
                            }
                        });
                    });


                    $("#btnHistorial").click(function () {
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'listarH'},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarHistorial();
                            },
                            error: function () {
                                alert("No se ha podido obtener la información");
                            }
                        });

                    });

                    //Mascota Funcion
                    $("#btnMascotas").click(function () {
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'ListarM'},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                                activarEditarEliminarMascota();
                            },
                            error: function () {
                                alert("No se ha podido obtener la información");
                            }
                        });

                    });


                    $("#btninhabilitados").click(function () {
                        $.ajax({
                            url: 'Veterinario',
                            method: 'POST',
                            data: {'accion': 'listarInhabilitadosVeterinario'},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                            },
                            error: function () {
                                alert("No se ha podido obtener la información");
                            }
                        });

                    });

                    $("#btnPerfil").click(function () {
                        $.ajax({
                            url: 'Usuario',
                            method: 'POST',
                            data: {'accion': 'perfil'},
                            success: function (respuesta) {
                                $("#contenido_principal").html(respuesta);
                            },
                            error: function () {
                                alert("No se ha podido obtener la información");
                            }
                        });
                    });


                });
            </script>

            <%if (request.getAttribute("error") != null) {%>
            ${error}
            <%} else {%>
            ${exito}
            <%}%> 
    </body>
</html>