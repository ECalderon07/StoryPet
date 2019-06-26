<%@page session="true"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>StoryPet! | </title>

        <!-- Bootstrap -->
        <link href="./vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link href="./vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
        <!-- NProgress -->
        <link href="./vendors/nprogress/nprogress.css" rel="stylesheet">
        <!-- Animate.css -->
        <link href="./vendors/animate.css/animate.min.css" rel="stylesheet">
        <!-- Custom Theme Style -->
        <link href="./build/css/custom.min.css" rel="stylesheet">
        <!-- Validaciones -->        
        <script src="js/jquery.validate.js" type="text/javascript"></script>
        <script src="js/messages_es.js.js" type="text/javascript"></script>
    </head>
    <style>
        label.error{
            position:absolute;
            display: block;
            color: red;
        }
        label.valid{
            padding:10px;
            margin-left:10px;
            display: inline;
            background: url("./images/images.png");            
        }
        input.error{
            border-color: red;
        }
        .body{
            background-image: url("images/dog.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            color: #000;
            font: oblique bold 120% cursive;
        }
        .InicioForm{
            border: 2px solid #000;
            border-radius: 25px;
            background-color: #ffffff;
            padding: 50px 50px 0px 50px;

            filter: alpha(opacity=100); /* For IE8 and earlier */
        }
        .formulario{
            border: 2px solid #000;
            border-radius: 25px;
            background-color: #ffffff;
            padding: 50px 50px 0px 50px;
        }
    </style>

    <body class="login body">
        <div>
            <a class="hiddenanchor" id="signup"></a>
            <a class="hiddenanchor" id="signin"></a>

            <div class="login_wrapper">
                <div class="animate form login_form">
                    <section class="login_content">                       
                        <form action="Usuario" method="post" class="InicioForm" >
                            <h1>Iniciar Sesion</h1>
                            <div>
                                <input type="text" name="correo" class="form-control" placeholder="Correo" value="ei@ei.com"  />
                            </div>
                            <div>
                                <input type="password" name="clave" class="form-control" value="123456789" placeholder="Contraseña"  />
                            </div>
                            <div>
                                <input class="btn btn-default submit btnIngresar text-center" type="submit" name="accion" value="ingresar">
                                <a class="reset_pass" href="recuperarContraseña.jsp">Olvidaste tu contraseña?</a>
                            </div>

                            <div class="clearfix"></div>

                            <div class="separator">
                                <p class="change_link">New to site?
                                    <a href="#signup" class="to_register"> Crear Cuenta </a>
                                </p>

                                <div class="clearfix"></div>
                                <br/>
                                <div>
                                    <h1><i class="fa fa-paw"></i> StoryPet!</h1>
                                    <p>©2019 All Rights Reserved. StoryPet! is a Bootstrap 3 template. Privacy and Terms</p>
                                </div>
                            </div>
                        </form>
                    </section>
                </div>

                <div id="register" class="animate form registration_form">
                    <section class="login_content">
                        <form action="Usuario" method="post" id="formulario" class="formulario" >
                            <h1>Crear Cuenta</h1>
                            <div>
                                <input type="text" class="form-control" name="cedula" placeholder="Cedula" />
                            </div>
                            <div>
                                <input type="text" class="form-control" name="usuario" placeholder="Usuario"  />
                            </div>
                            <div>
                                <input type="password" class="form-control" name="clave" placeholder="Clave" />
                            </div>
                            <div>
                                <input type="text" class="form-control" name="nombres" placeholder="Nombres"  />
                            </div>
                            <div>
                                <input type="text" class="form-control" name="apellidos" placeholder="Apellidos" />
                            </div>
                            <div>
                                <input type="text" class="form-control" name="telefono" placeholder="Telefono" />
                            </div>
                            <div>
                                <input type="email" class="form-control" name="correo" placeholder="Correo" />
                            </div>                         
                            <div>
                                <input type="hidden" name="rol" value="usuario">                             
                            </div>                         
                            <div>
                                <button class="btn btn-default submit" id="btnRegistrar" type="submit" >Registar</button>
                            </div>

                            <div class="clearfix"></div>

                            <div class="separator">
                                <p class="change_link">Already a member ?
                                    <a href="#signin" class="to_register"> Iniciar Sesion </a>
                                </p>
                                <div class="clearfix"></div>
                                <br />

                                <div>
                                    <h1><i class="fa fa-paw"></i> StoryPet!</h1>
                                    <p>©2016 All Rights Reserved. StoryPet! is a Bootstrap 3 template. Privacy and Terms</p>
                                </div>
                            </div>
                        </form>
                    </section>
                </div>
            </div>
        </div>



        <script>

            $(document).ready(function () {

                $(".InicioForm").validate({
                    rules: {
                        correo: {
                            required: true,
                            email: true
                        },
                        clave: {
                            required: true
                        }
                    }
                });


                $("#formulario").validate({
                    rules: {
                        cedula: {
                            required: true,
                            number: true,
                            rangelength: [9, 10]
                        },
                        usuario: {
                            required: true
                        },
                        clave: {
                            required: true,
                            pasword: true
                        },
                        nombres: {
                            required: true
                        },
                        apellidos: {
                            required: true
                        },
                        telefono: {
                            required: true,
                            number: true,
                            rangelength: [7, 10]
                        },
                        correo: {
                            required: true,
                            email: true
                        }
                    },
                    messages: {
                        Cedula: {
                            required: "Campo obligatorio",
                            number: "Campo númerico",
                            rangelength: "Debe estar entre 1 a 10 dígitos"
                        },
                        Telefono: {
                            required: "Campo obligatorio",
                            number: "Campo númerico",
                            rangelength: "Debe estar entre 7 a 10 números"
                        }
                    }

                });


            });



        </script>

        <%
            if (request.getParameter("cerrar") != null) {
                HttpSession sesion = request.getSession();
                sesion.invalidate();
                response.sendRedirect("index.jsp");
            } else {

            }
        %>

        <% if (request.getAttribute("error") != null) {%>
        ${error}
        <%} else {%>
        ${exito}
        <%}%>
    </body>
</html>
