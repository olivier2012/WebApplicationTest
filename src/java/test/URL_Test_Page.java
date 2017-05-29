package test;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;

public class URL_Test_Page extends HttpServlet  {

   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.println("<h3>Request URL parts</h3>");
        pw.println("<ol>");
        pw.println("<li>ContextPath=<b style='color:red'>" + req.getContextPath() + "</b></li>");
        pw.println("<li>ServletPath=<b style='color:blue'>" + req.getServletPath() + "</b></li>");
        pw.println("<li>PathInfo=<b style='color:orange'>" + req.getPathInfo() + "</b></li>");
        pw.println("<li>QueryString=<b style='color:green'>" + req.getQueryString() + "</b></li>");
        pw.println("</ol>");
        pw.println("<b > getRequestURI() = " + req.getRequestURI() +  "</b>" );	
    }
}