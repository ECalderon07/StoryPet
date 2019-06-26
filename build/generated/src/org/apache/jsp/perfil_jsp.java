package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class perfil_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <!-- Meta, title, CSS, favicons, etc. -->\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body class=\"nav-md\">\n");
      out.write("        <div class=\"container body\">\n");
      out.write("            <div class=\"main_container\">\n");
      out.write("\n");
      out.write("                ");

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
                
      out.write("\n");
      out.write("\n");
      out.write("                <!-- page content -->\n");
      out.write("                <div class=\"\" role=\"main\">\n");
      out.write("                    <div class=\"\">\n");
      out.write("                        <div class=\"page-title\">\n");
      out.write("                            <div class=\"title_left\">\n");
      out.write("                                <h3>Usuario Perfil</h3>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                            <div class=\"title_right\">\n");
      out.write("                                <div class=\"col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search\">\n");
      out.write("                                    <div class=\"input-group\">\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"clearfix\">\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-12 col-sm-12 col-xs-12\">\n");
      out.write("                                <div class=\"x_panel\">\n");
      out.write("                                    <div class=\"x_title\">\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"x_content\">\n");
      out.write("                                        <div class=\"col-md-3 col-sm-3 col-xs-12 profile_left\">\n");
      out.write("                                            <div class=\"profile_img\">\n");
      out.write("                                                <div id=\"crop-avatar\">\n");
      out.write("                                                    <!-- Current avatar -->\n");
      out.write("                                                    <img class=\"img-responsive avatar-view\" src=\"images/picture.jpg\" alt=\"Avatar\" title=\"Change the avatar\">\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <h3>");
      out.print( nombre + " " + apellido);
      out.write("</h3>\n");
      out.write("\n");
      out.write("                                            <ul class=\"list-unstyled user_data\">                              \n");
      out.write("                                                <li>\n");
      out.write("                                                    <i class=\"fa fa-briefcase user-profile-icon\"></i> ");
      out.print( rol);
      out.write("\n");
      out.write("                                                </li>\n");
      out.write("\n");
      out.write("                                            </ul>\n");
      out.write("\n");
      out.write("                                            <br />\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"col-md-9 col-sm-9 col-xs-12\">\n");
      out.write("                                            <!-- start of user-activity-graph -->\n");
      out.write("                                            <div id=\"graph_bar\" style=\"width:100%; height:280px;\">\n");
      out.write("\n");
      out.write("                                                <label>Nombres</label>\n");
      out.write("                                                <label>");
      out.print( nombre);
      out.write("</label><br/>\n");
      out.write("                                                <label>Apellidos</label>\n");
      out.write("                                                <label>");
      out.print( apellido);
      out.write("</label><br/>\n");
      out.write("                                                <label>Correo</label>\n");
      out.write("                                                <label> ");
      out.print( correo);
      out.write("</label><br/>\n");
      out.write("                                                <label>Telefono</label>\n");
      out.write("                                                <label>");
      out.print( telefono);
      out.write("</label><br/>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                            <!-- end of user-activity-graph -->\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <!-- /page content -->\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
