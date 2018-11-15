import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class cokk extends HttpServlet
{
public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
{
res.setContentType("text/html");
PrintWriter pw=res.getWriter();
Cookie ck[]=req.getCookies();


/*for(int i=0;i<k.length;i++)
{
pw.println("");
}*/
}
}