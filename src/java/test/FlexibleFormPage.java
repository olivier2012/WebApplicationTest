package test;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.servlet.*;
import javax.servlet.http.*;

public class FlexibleFormPage extends HttpServlet  {
    private String connectionURL ;   //field for storage of  DB  connection string
    
    public void init( )   {          //this method is used for one-time activities , it's called when servlet is initialized 
        connectionURL = getServletContext().getInitParameter("connect_string");
        try {  /*loading Oracle driver, usually is done automatically*/  Class.forName("oracle.jdbc.driver.OracleDriver");  } 
        catch (Exception ex)    {       System.out.println("\t" + ex);      }
    }	

   @Override
   public void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException 
    {
        
        
        resp.setContentType("text/html");
        
        /*get connection from database then get data from here */
        String connectionURL = getServletContext().getInitParameter("connect_string");
        String fnameVal = req.getParameter("fname");
        String lnameVal = req.getParameter("lname");
        String acourse = req.getParameter("course");
        fnameVal =  returnEmptyIfNull(fnameVal);
        lnameVal =  returnEmptyIfNull(lnameVal);
        acourse =  returnEmptyIfNull(acourse);
        
        PrintWriter pw = resp.getWriter();
        try{
        pw.println("<form action='/WebApplicationTest/selectGrades' method='get'>"); 
        pw.println("<table border='1' width='70%' >");
        pw.println("<h3> Selection parameters  :  </h3>");
        pw.println("<tr><th>First name </th><th>Last name </th><th>Course </th></tr>");
        
          pw.println("<tr><td> <select name='fname' ><option> --- </option> ");
        readFromDBFname(connectionURL,  pw);        
         pw.println("</select></td>   ");
        
        pw.println("<td> <select name='lname'> <option>--- </option>");
        readFromDBLname(connectionURL,  pw);        
         pw.println("</select></td>  ");
         
        pw.println("<td> <select name='course'> <option>--- </option>");
        readFromDBCourse(connectionURL,  pw);        
         pw.println("</select></td> </tr>  ");
          pw.println("</table>");
           pw.println("<br/><hr>");
        pw.println("Input two Grade values : <br/><br/>");
        pw.print("<label>The Grade from  </label><input type='text' name='fvalue' value='60' />");
        pw.println("<label>  To  </label><input type='text' name='lvalue' value='100' /><br/><br/>");
        pw.println("<input type='submit'  value='send'>"); 
       
        pw.println("</form >"); 

        }
         catch(Exception e){
         pw.println("<body>");
         pw.print("<p><i>An error during calculations <i></p>");
    
    } finally{
            pw.println("</body>"); 
        }
        
    }

    private void readFromDBLname(String connectionURL, PrintWriter pw) {
        try 
        (
            Connection con = DriverManager.getConnection(connectionURL);
            Statement stmt = con.createStatement();
        )
        {  ResultSet rs =  stmt.executeQuery("SELECT  DISTINCT lname FROM T_Stud ");
            while( rs != null  &&  rs.next(  )  ){
                   pw.println("<option>" + rs.getString("lname") + "</option>");
            }
        }
        catch(Exception e){
		pw.println("<tr><td colspan='2'>An error \"" +  e.getMessage() +  "\" during DB reading</td></tr>"); 
        }
    }
    
    private void readFromDBFname(String connectionURL, PrintWriter pw) {
        try 
        (
            Connection con = DriverManager.getConnection(connectionURL);
            Statement stmt = con.createStatement();
        )
        {  ResultSet rs =  stmt.executeQuery("SELECT  DISTINCT fname FROM T_Stud ");
            while( rs != null  &&  rs.next(  )  ){
                   pw.println("<option>" + rs.getString("fname") + "</option>");
            }
        }
        catch(Exception e){
		pw.println("<tr><td colspan='2'>An error \"" +  e.getMessage() +  "\" during DB reading</td></tr>"); 
        }
    }
    
        private void readFromDBCourse(String connectionURL, PrintWriter pw) {
        try 
        (
            Connection con = DriverManager.getConnection(connectionURL);
            Statement stmt = con.createStatement();
        )
        {  ResultSet rs =  stmt.executeQuery("SELECT  DISTINCT Course FROM T_Course ");
            while( rs != null  &&  rs.next(  )  ){
                   pw.println("<option>" + rs.getString("course") + "</option>");
            }
        }
        catch(Exception e){
		pw.println("<tr><td colspan='2'>An error \"" +  e.getMessage() +  "\" during DB reading</td></tr>"); 
        }
    }
    private String returnEmptyIfNull(String inp) { return inp == null ? "" : inp;} 	//simple  function 
}// class

/*

  <!-- exercise 2   -->
   <servlet>
        <servlet-name>SelectGradesPage</servlet-name>
        <servlet-class>test.SelectGradesPage</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>SelectGradesPage</servlet-name>
        <url-pattern>/selectGrades</url-pattern>
    </servlet-mapping>
*/