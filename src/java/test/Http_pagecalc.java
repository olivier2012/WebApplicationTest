package test;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class Http_pagecalc extends HttpServlet  {

   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

         
        String pathvalue = req.getPathInfo();
        String []ar = pathvalue.split("/");
          for(String a:ar){
           pw.println("  " + a + "<br>");
          } 
                 String empty=null;
                   String option = null;
                   int firPar = 0 ;
                   int secPar = 0 ;
        if (ar.length == 4){
           empty=ar[0]; 
           option=ar[1];
          firPar = parseInt(ar[2]);
           secPar = parseInt(ar[3]);
        }else{
            pw.print("An error during calculations !");
        
        }
  /*      int firPar = parseInt(req.getParameter("firPar"));
        int secPar = parseInt(req.getParameter("secPar"));
      String option = req.getParameter("option");
       String bgcol = getInitParameter("backgroundcolor");
       String forecolor =  getInitParameter("forecolor");*/
         String bgcol = "white" ;
       String forecolor =  "black";
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
              pw.println("<h3>Request URL parts</h3>");
        pw.println("<ol>");
        pw.println("<li>ContextPath=<b style='color:red'>" + req.getContextPath() + "</b></li>");
        pw.println("<li>ServletPath=<b style='color:blue'>" + req.getServletPath() + "</b></li>");
        pw.println("<li>PathInfo=<b style='color:orange'>" + req.getPathInfo() + "</b></li>");
        pw.println("<li>QueryString=<b style='color:green'>" + req.getQueryString() + "</b></li>");
        pw.println("</ol>");
        pw.println("<b > getRequestURI() = " + req.getRequestURI() +  "</b>" );	
      
      pw.println("</body>");
    }
}