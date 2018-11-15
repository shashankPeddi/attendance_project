import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class mymail1 extends HttpServlet
{

protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException 

{ 

res.setContentType("text/html");
PrintWriter pw = res.getWriter();
ServletContext cntxt = getServletContext();
File file=new File("tttt.text");
//OutputStream ins = cntxt.getResourceAsStream(file);

      try{ 
	
String name=req.getParameter("tf1");

 	
Connection conn = null;
   Statement stmt = null;   

   Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_ext","root","root");
    FileWriter fw = new FileWriter(file.getAbsoluteFile());     
BufferedWriter br = new BufferedWriter(fw);
PreparedStatement pst=conn.prepareStatement("SELECT * from cse_c_attendance");
            ResultSet rst = pst.executeQuery();

      while(rst.next()){
         String id  = rst.getString("attendance_absent");
          br.append(id);        
          }
      
}
catch(Exception e){ 
          
      } 
   } 
} 
