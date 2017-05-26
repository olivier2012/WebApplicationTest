package test;
/*use the StringBuilder */
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Enumeration;
import javax.servlet.*;

public class getParameterName111 extends GenericServlet {

    @Override
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        StringBuilder result=new StringBuilder(); 
        int releng=0;
        pw.println("<table border='1' width='40%' >");
        pw.println("<caption> All parameters with their  values</caption>");
        pw.println("<tr><th>Parameter</th><th>Value</th></tr>");
        Enumeration<String> paramNames = req.getParameterNames();
        while (paramNames.hasMoreElements()) {
            releng++;
            String paramName = paramNames.nextElement();
            String[] allValues = req.getParameterValues(paramName);
            /*
            int lenall = allValues.length ;
            int lenres = resultArrays.length ;
            int bothlen = lenall + lenres;
            if (lenres > 0) {
                resultArrays = Arrays.copyOf(resultArrays, bothlen);
            } else {
                resultArrays = Arrays.copyOf(allValues, lenall);
            } 
            System.arraycopy(allValues, 0, resultArrays, lenres, lenall);*/
            
            result.append(Arrays.toString(allValues)); 
            pw.println("<tr><td>" + paramName + "</td><td>" + Arrays.toString(allValues) + "</td></tr>"); 
        }
         pw.println("</table>");
        pw.println("<hr/>");
        pw.print("Result=  [");
            pw.print(result);
        pw.println(" ] ");
         pw.println("<hr/>");
      
    }	// service( )
}
