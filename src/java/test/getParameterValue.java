package test;

import java.io.*;
import java.util.Date;
import javax.servlet.*;


public class getParameterValue extends GenericServlet{
    
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        
        pw.println("<table border='1' width='70%' >");
        pw.println("<caption> All values of parameter \"name\"</caption>");
        pw.println("<tr><th>#</th><th>Value</th></tr>");
        String vals[] = req.getParameterValues("name");
        for(int i = 0; i< vals.length; i++) {
            pw.println("<tr><td>" + (i+1) + "</td><td>" + vals[i] + "</td></tr>");
        }
        pw.println("</table>");
    }  
    
}

