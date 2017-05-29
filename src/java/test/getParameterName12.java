package test;


import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.*;

public class getParameterName12 extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        ArrayList<String> rA = new ArrayList<String>();
        ArrayList<String> pA = new ArrayList<String>();
        pw.println("<table border='1' width='40%' >");
        pw.println("<caption> All parameters with their  values</caption>");
        pw.println("<tr><th>Parameter</th><th>Value</th></tr>");
        Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            String paramName = paramNames.nextElement();
            String[] allValues = req.getParameterValues(paramName);
            rA.add(paramName);
            Collections.addAll(pA, allValues);
            pw.println("<tr><td>" + paramName + "</td><td>" + Arrays.toString(allValues) + "</td></tr>"); 
        }
         pw.println("</table>");
        pw.println("<hr/>");
        pw.print("Result=  ["); 
        String ppp = null;
        for(Object pp:pA){
         if (ppp==null){
             ppp=pp+",";
            }else{
          ppp=ppp+","+pp;
         }
        } 
        pw.print(ppp);
        pw.println(" ] ");
         pw.println("<hr/>");
      
    }	// service( )
}
