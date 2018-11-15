import java.servlet.*;
import java.servlet.http*;
import java.io.*;
public class logout extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse req)
{
res.setContenet("text/html");
PrintWriter pw=res.getWriter();
req.getRequestDispatcher("lecture.html").include(req,res);
Cookie ck=new Cookie("name","");
ck.setMaxAge(0);
res.addCookie(ck);
pw.println("Sucessed in logout");
}
}
