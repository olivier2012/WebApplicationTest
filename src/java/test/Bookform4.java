package test;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class Bookform4 extends  GenericServlet {
     private String connectionURL ;   //field for storage of  DB  connection string
     
    public void init( )   {          //this method is used for one-time activities , it's called when servlet is initialized 
        connectionURL = getServletContext().getInitParameter("connect_string");
        try {  /*loading Oracle driver, usually is done automatically*/  Class.forName("oracle.jdbc.driver.OracleDriver");  } 
        catch (Exception ex)    {       System.out.println("\t" + ex);      }
    }	
    
    public void service(ServletRequest req, ServletResponse resp) throws IOException, ServletException  {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        
        String connectionURL = getServletContext().getInitParameter("connect_string");
        String initAuthorvalue = getServletContext().getInitParameter("author");
        
        String fnameVal = req.getParameter("name");
        String lnameVal = req.getParameter("author");
        fnameVal =  returnEmptyIfNull(fnameVal);
        lnameVal =  returnEmptyIfNull(lnameVal);
        String fnameInfo = " first name " + ( fnameVal.isEmpty() ? " - <u>any</u> " : " starts with \"" + fnameVal + "\"");
        String lnameInfo = " , last name " + ( lnameVal.isEmpty() ? " - <u>any</u> " : " starts with \"" + lnameVal + "\"");
                
        pw.println("<table border='1' width='70%' >");
        pw.println("<h3> Books s that match selection parameters  : "+ fnameInfo + lnameInfo +" </h3>");
        pw.println("<tr><th>Author name </th><th>Last name </th></tr>");
        
        readFromDB(connectionURL, fnameVal, lnameVal, pw);
        pw.println("</table>");
        pw.println("<footer  <hr/>");
          pw.println("<i> Author:" + initAuthorvalue + "</i>");
        pw.println("</footer>");
    }
    
    private void readFromDB(String connectionURL, String fnameVal, String lnameVal, PrintWriter pw) {
        try 
        (
            Connection con = DriverManager.getConnection(connectionURL);
            Statement stmt = con.createStatement();
        )
        {  ResultSet rs =  stmt.executeQuery("SELECT * FROM books WHERE authors LIKE   '" +  lnameVal +
                    "%'    AND     name LIKE    '" + fnameVal  + "%'  ");
            while( rs != null  &&  rs.next(  )  ){
                   pw.println("<tr><td>" + rs.getString("name") + "</td><td>" +
                           rs.getString("authors") + "</td></tr>");
            }
        }
        catch(Exception e){
		pw.println("<tr><td colspan='2'>An error \"" +  e.getMessage() +  "\" during DB reading</td></tr>"); 
        }
    }
    private String returnEmptyIfNull(String inp) { return inp == null ? "" : inp;} 	//simple  function 
}// class
