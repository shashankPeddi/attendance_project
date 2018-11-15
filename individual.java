import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class individual extends HttpServlet
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
pw.println("attendance ok");
else
pw.println("not ok");

PreparedStatement pst=con.prepareStatement("SELECT * FROM cse_c_attendance WHERE  attendance_absent Like '%$ID,%' OR attendance_absent Like '%,$ID');
ResultSet rst=pst.executeQuery();
}
catch(Exception e)
{
pw.println(e);
}
}
}