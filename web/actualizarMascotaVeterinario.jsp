
<%@page import="VO.MascotasVO"%>
<%@page import="DAO.MascotasDAO"%>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <%
            MascotasDAO mascotasDAO = new MascotasDAO();
            String id = request.getAttribute("idMascota").toString();
            MascotasVO mascotasVO = (MascotasVO) mascotasDAO.listarId(id);
        %>
        <div class="container">
            <div class="col-lg-6">      
                <form id="formActualizarMascota" action="Veterinario" method="POST">                   
                    <label>Nombre</label>
                    <input type="text" class="form-control" name="nombre" id="nombre" value="<%= mascotasVO.getNombre()%>" ><br>
                    <label>Fecha Nacimiento</label>
                    <input type="date" class="form-control" min="2011-01-01" max="2019-12-31" name="fechaNacimiento" id="fecha" value="<%= mascotasVO.getFechaNacimiento()%>"><br>
                    <label>Sexo</label>
                    <input type="text" class="form-control" name="sexo" id="sexo" value="<%= mascotasVO.getSexo()%>"><br>
                    <input type="hidden" name="idMascota" value="<%= mascotasVO.getIdMascota()%>" ><br>
                    <input type="hidden" name="fkRaza" value="<%= mascotasVO.getFKRaza()%>" ><br>
                    <input type="hidden" name="fkUsuario" value="<%= mascotasVO.getFKUsuario()%>" >
                    <input class="btn btn-primary" type="submit"   name="accion" value="ActualizarM">
                </form>        
            </div>
        </div>   

        <%if (request.getAttribute("error") != null) {%>
        ${error}
        <%} else {%>
        ${exito}
        <%}%>


    </body>
</html>
