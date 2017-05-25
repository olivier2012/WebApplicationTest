package test;

import test.fileData;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.*;



public class file_folder12 extends GenericServlet{
    
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException{
      resp.setContentType("text/html");
      PrintWriter pw= resp.getWriter();
      String sfolder = req.getParameter("folder");
      String ssort = req.getParameter("sort");
      String sfilter = req.getParameter("ext");
      pw.println("<body >");
      pw.println("<table border=1px;>");
      pw.println("<thead>The Directory : </thead>");
      pw.println("<tbody>");
      pw.println("<th> Name </th><th>   Size (bytes)  </th>");
      File dir = new File(sfolder);
      List<fileData> fal = new ArrayList<fileData>();
      File[] list = dir.listFiles(new FilenameFilter(){
        public boolean accept(File dir,String name){
          return name.toLowerCase().endsWith(sfilter);
        }
      });
    if (dir.exists()){
      for(File f:list){
         String name = f.getName();
         long length = f.length();
         fal.add(new fileData(name,length));         
      }
      if (ssort.equals("size")){
       Collections.sort(fal);
       
        for(fileData f:fal)    
            {
          pw.println("<tr><td>"+f.getFilename()+"</td><td>"+ f.getFilesize() +"</td> </tr>");
            }   
      }else if (ssort.equals("name")){
          String[] dirlist = dir.list(new FilenameFilter(){
        public boolean accept(File dir,String name){
          return name.toLowerCase().endsWith(sfilter);
        }
      });
          Arrays.sort(dirlist);
          for(String d:dirlist){
            pw.println("<tr><td>"+d+"</td><td>"+ d.length()*1024 +"</td> </tr>");
          }
      }
      
      pw.println("</tbody>");
      pw.println("</table>");
      pw.println("</body>");
    }
    
}
}