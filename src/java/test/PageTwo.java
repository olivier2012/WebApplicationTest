package test;

import java.io.*;
import javax.servlet.*;


public class PageTwo extends GenericServlet{
    
    @Override
    public void service(ServletRequest req2, ServletResponse resp) throws IOException{
      resp.setContentType("text/html");
      PrintWriter pw= resp.getWriter();
      pw.println("<h1>Page2</h1>");
    }
    
}
