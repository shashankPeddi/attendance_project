import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class quizval extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
String code=req.getParameter("tf1").trim();
String code1="";
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_ext","root","root");
if(con!=null)
pw.println("ok");
else
pw.println("not ok");
Statement st=con.createStatement();
String q="select * from answers where code="+"'"+code+"'";
ResultSet rst=st.executeQuery(q);
while(rst.next())
{
code1=rst.getString(6).trim();
}
if(code.equals(code1))
{
pw.println("user is authorized");
res.sendRedirect("vali.jsp");
}
else
{
pw.println("<script> window.alert('Wrong code');</script>");
pw.println("<script> window.open('vali.jsp','_self');</script>");

}

}
catch(Exception e)
{
pw.println(e);
}

}
}