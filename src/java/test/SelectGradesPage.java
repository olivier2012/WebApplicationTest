package test;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class SelectGradesPage extends HttpServlet  {

   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException 
    {
        resp.setContentType("text/html");
        
        PrintWriter pw = resp.getWriter();
        try{
         
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
            pw.print("<p><i>Not enough data or more datas !<i></p>");
        
        }
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
          pw.println("you input " + firPar + "  " +option + "  " + secPar + "  result : " +((double)firPar/secPar) );
      }  
      
        } catch(Exception e){
         pw.println("<body>");
         pw.print("<p><i>An error during calculations <i></p>");
    
    } finally{
            pw.println("</body>"); 
        }
        
    }
}