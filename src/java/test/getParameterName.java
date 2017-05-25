package test;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.*;


public class getParameterName extends GenericServlet{
    
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter( );                
        pw.println("<table border='1' width='40%' >");
        pw.println("<caption> All parameters with their  values</caption>");
        pw.println("<tr><th>Parameter</th><th>Value</th></tr>");
        Enumeration<String> paramNames = req.getParameterNames( );
        while(  paramNames.hasMoreElements( )  ){
            String paramName = paramNames.nextElement();
            String []allValues = req.getParameterValues(paramName);
            pw.println("<tr><td>" + paramName + "</td><td>" + Arrays.toString(allValues) + "</td></tr>");
        }
        pw.println("</table>");
    }	// service( )
    
}

