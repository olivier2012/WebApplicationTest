package test;

import java.io.*;
import java.util.*;
import javax.servlet.*;


public class file_folder1 extends GenericServlet{
    
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException{
      resp.setContentType("text/html");
      PrintWriter pw= resp.getWriter();
      String sfolder = req.getParameter("folder");
      String ssort = req.getParameter("sort");
      pw.println("<body >");
      pw.println("<table border=1px;>");
      pw.println("<thead>The Directory : </thead>");
      pw.println("<tbody>");
      pw.println("<th> Name </th><th>   Size (bytes)  </th>");
      File dir = new File(sfolder);
      if (!dir.exists())
          return; 

      //dir exists 
      File[] listOfFiles = dir.listFiles(
        new FileFilter() {
          @Override
          public boolean accept(File file) {  return file.isFile();    }
        }
      );
      
    

     Arrays.sort(listOfFiles, new FileComp(ssort));         
      
      for(File f:listOfFiles){
         String name = f.getName();
         long length = f.length();
         pw.println("<tr><td>" + name + "</td><td>" + length + "</td></tr>");          
      }
      
      pw.println("</tbody>");
      pw.println("</table>");
      pw.println("</body>");
    
    
    }//service
}

class FileComp implements Comparator<File> {    
    
    private String sortKind;

    public FileComp(String sortKind) {       this.sortKind = sortKind;   }
    
    
    
    @Override
    public int compare(File a , File b){
        if (sortKind == null)
             return a.getName().toLowerCase().compareTo(b.getName().toLowerCase());
        if (sortKind.equals("size"))
          return a.length() > b.length() ? 1 : a.length() < b.length() ? -1 : 0;
        else
           return a.getName().toLowerCase().compareTo(b.getName().toLowerCase());
    }
}
    
