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
        <title>StoryPet</title>
    </head>
    <body>
        <form action="ContraladorRecuperar" method="post">
            <label for="male">Correo</label><br>
            <input type="email" name="correo" id="correo" ><br>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
