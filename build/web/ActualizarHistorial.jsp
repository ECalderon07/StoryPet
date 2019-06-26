<%-- 
    Document   : ActualizarHistorial
    Created on : 20/03/2019, 01:24:54 PM
    Author     : Daniel
--%>


<%@page import="VO.HistorialVo"%>
<%@page import="DAO.HistorialDao"%>
<%@page import="DAO.HistorialDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="js/jquery.validate.js" ></script>
        <script src="js/messages_es.js.js"></script>
    </head>
    <body>
        <%
            HistorialDao HistorialDao = new HistorialDao();
            String id = request.getAttribute("idHistorial").toString();
            HistorialVo HistVo = (HistorialVo) HistorialDao.ListarId(id);

        %>
        <div class="container text-center">
            <h1 class="text-center">Actualizar Historial</h1>
            <form action="Historial" method="POST" id="formActualizarHisto">
                <label>Novedad</label><br>
                <textarea style="width: 355px;" class="inputGroupContainer" placeholder="Novedad" name="novedad" ><%=HistVo.getNovedad()%></textarea><br>
                <!--label>Servicio:</label><br>
                <input type="text" name="IdServicio" value="<%=HistVo.getFKServicio()%>"!--><br>
                
                <input type="hidden" name="id" value="<%= HistVo.getIdHistorialClinico()%>"><br>
                <input id="btnActualizarHisto" class="btn btn-success" type="submit" name="accion" value="Actualizar"> <br><br>
            </form> 
        </div>
                
        <%if (request.getAttribute("error") != null) {%>
        ${error}
        <%} else {%>
        ${exito}
        <%}%> 

        <script>
            $(document).ready(function () {
                $("#formActualizarHisto").validate({
                    rules: {
                        novedad: {
                            required: true,
                        }
                    }
                })

            })
        </script>

    </body>
</html>
