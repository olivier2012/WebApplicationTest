package test;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.*;
import java.util.Date;
import javax.servlet.*;


public class file_folder extends GenericServlet{
    
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException{
      resp.setContentType("text/html");
      PrintWriter pw= resp.getWriter();
      String sfolder = req.getParameter("folder");
      pw.println("<body >");
      pw.println("<table border=1px;>");
      pw.println("<thead>The Directory : </thead>");
      pw.println("<tbody>");
      pw.println("<th> Name </th><th>   Size (bytes)  </th>");
      File dir = new File(sfolder);
      if(dir.exists()){
          String[] dirlist=dir.list();
            for(String d:dirlist){
          pw.println("<tr><td>"+d+"</td><td>"+ d.length() +"</td> </tr>");
            }
                
                  
                  
      }
      pw.println("</tbody>");
      pw.println("</table>");
      pw.println("</body>");
    }
    
}
