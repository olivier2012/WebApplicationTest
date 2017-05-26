<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<% 
   GregorianCalendar currentDate = new GregorianCalendar();
   int currentYear = currentDate.get(Calendar.YEAR);
%>
<p> &copy;CopyRight <%= currentYear %> </p>
    </body>
</html>
