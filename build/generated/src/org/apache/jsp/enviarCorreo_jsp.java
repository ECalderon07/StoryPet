package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class enviarCorreo_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Prueba</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form class=\"form-horizontal\" action=\"Mail\" method=\"post\">\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label class=\"control-label col-sm-2\" for=\"\">Destinatario:</label>\n");
      out.write("                <div class=\"col-sm-10\">\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"Destinatario\" id=\"Destinatario\" placeholder=\"Enter email\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label class=\"control-label col-sm-2\" for=\"\">Asunto:</label>\n");
      out.write("                <div class=\"col-sm-10\"> \n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"Asunto\" id=\"Asunto\" placeholder=\"Enter password\">\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\">\n");
      out.write("                <label class=\"control-label col-sm-2\" for=\"\">Mensaje:</label>\n");
      out.write("                <div class=\"col-sm-10\"> \n");
      out.write("                    <textarea rows=\"4\" cols=\"50\" name=\"Mensaje\" id=\"Mensaje\">\n");
      out.write("                        \n");
      out.write("                    </textarea>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"form-group\"> \n");
      out.write("                <div class=\"col-sm-offset-2 col-sm-10\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-default\">Submit</button>\n");
      out.write("                    <span class=\"message\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
