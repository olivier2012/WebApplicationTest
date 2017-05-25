package test;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.*;
import java.util.Date;
import javax.servlet.*;


public class changeBColor extends GenericServlet{
    
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException{
      resp.setContentType("text/html");
      PrintWriter pw= resp.getWriter();
      String bcolor = req.getParameter("bcolor");
      String tcolor = req.getParameter("tcolor");
      
      pw.println("<body style='color:"+tcolor+"; background-color:"+bcolor+";'>");
      
      pw.println("<b> Page One </b> <br/> Servlet works !! </em> <br/>");
      Date dt = new Date();
     // String  time1 = date.getTime().toString;
  //      String 
      pw.println("date="+ String.format("%TY %TB %Td",dt,dt,dt)+"    time="+String.format("%TH  %TM  %TS", dt,dt,dt));
      
      pw.println("</body>");
    }
    
}
