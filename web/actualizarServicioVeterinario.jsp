<%-- 
    Document   : edit
    Created on : 11/04/2019, 02:29:05 PM
    Author     : Daniel
--%>

<%@page import="VO.ServiciosVo"%>
<%@page import="DAO.ServicioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div class="container text-center">
            <div >
                <%
                    ServicioDAO dao = new ServicioDAO();
                    String id = request.getAttribute("idServicio").toString();
                    ServiciosVo Servicio = (ServiciosVo) dao.ListarId(id);

                %>
                <h1 class="text-center">Actualizar Servicio</h1>
                <form action="Veterinario">
                    Tipo de Servicio:<br>
                    <input class="form-control" type="text" name="txtServicio" value="<%= Servicio.getTipoServicio()%>"><br>
                    <input type="hidden" name="txtidServicio" value="<%= Servicio.getIdServicio()%>">
                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar">
                </form>
            </div>           
        </div>
    </body>
</html>
