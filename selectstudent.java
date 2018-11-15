import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class selectstudent extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_ext","root","root");
if(con!=null)
pw.println("<tr>ok</tr>");
else
pw.println("not ok");

PreparedStatement pst1=con.prepareStatement("select * from cse_c_attendance");
ResultSet rst=pst1.executeQuery();
while(rst.next())
{
pw.println("present:"+rst.getString(1));
pw.println("present:"+rst.getString(2));
pw.println("present:"+rst.getString(3));
pw.println("present:"+rst.getString(4));
}
}
catch(Exception e)
{
pw.println(e);
}
}
}