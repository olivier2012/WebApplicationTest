package test;

import java.io.*;
import static java.lang.Integer.parseInt;
import java.util.Date;
import javax.servlet.*;


public class PageCalc extends GenericServlet{
    
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException{
      resp.setContentType("text/html");
      PrintWriter pw= resp.getWriter();
        int firPar = parseInt(req.getParameter("firPar"));
        int secPar = parseInt(req.getParameter("secPar"));
      String option = req.getParameter("option");
       String bgcol = getInitParameter("backgroundcolor");
       String forecolor =  getInitParameter("forecolor");
       pw.println("<body style='background-color:" + bgcol + "; color: " + forecolor + ";'>");
      if (option.equals("plus"))
      {pw.println("you input " + firPar + "  " +option + "  " + secPar + "  result : " + (firPar+secPar) );}
      else if (option.equals("min")){
          pw.println("you input " + firPar + "  " +option + "  " + secPar + "  result : " + (firPar-secPar) );}
      else if(option.equals("pro")){
          pw.println("you input " + firPar + "  " +option + "  " + secPar + "  result : " + (firPar*secPar) );} 
      else if (option.equals("div")){
          pw.println("you input " + firPar + "  " +option + "  " + secPar + "  result : " +((double)firPar/secPar) );}  
          
      //pw.println("<body style='color:"+tcolor+"; background-color:"+bcolor+";'>");
      
      pw.println("<b> Page One </b> <br/> Servlet works !! </em> <br/>");
      Date dt = new Date();
     // String  time1 = date.getTime().toString;
  //      String 
      pw.println("date="+ String.format("%TY %TB %Td",dt,dt,dt)+"    time="+String.format("%TH  %TM  %TS", dt,dt,dt));
      
      pw.println("</body>");
    }
    
}
