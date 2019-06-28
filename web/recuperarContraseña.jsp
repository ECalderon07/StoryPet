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
        <form method="POST" action="RecuperarPass">
            <div class="modal-body mx-3">
                
                <div class="md-form mb-5">
                    <label data-error="wrong" data-success="right" for="orangeForm-name">Destinatario</label>
                    <input type="email" id="" class="form-control validate" name="destinatario" required>
                </div>

            </div>

            <div class="modal-footer d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">Enviar</button>
                <span class="message">${message}</span>
            </div>
        </form>
    </body>
</html>
