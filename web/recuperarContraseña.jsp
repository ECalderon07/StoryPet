<%-- 
    Document   : recuperarContraseña
    Created on : Jun 24, 2019, 6:13:22 PM
    Author     : Edwin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>StoryPet</title>

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
                        <form method="POST" action="RecuperarPass" class="InicioForm">
                            <h1>Recuperar Contraseña</h1>
                            <div>
                                <label data-error="wrong" data-success="right" for="orangeForm-name">Correo</label>
                                <input type="email" name="destinatario" class="form-control"  placeholder="Ingrese Correo" />
                            </div>
                            <div>
                                <button type="submit" class="btn btn-primary">Enviar</button>
                            </div>
                        </form>
                    </section>
                </div>
            </div>
    </body>
</html>
