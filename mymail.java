import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class mymail extends HttpServlet
{
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException

 { 
 res.setContentType("text/html");
PrintWriter pw=res.getWriter(); 
  Connection conn = null;
   Statement stmt = null;
   try{ 
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_ext","root","root");
      stmt = conn.createStatement();

      File file = new File("filename.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);

      String sql = "SELECT * from cse_c_attendance";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         String id  = rs.getString("attendance_absent");
         bw.append(id);
          } 
      rs.close();
      bw.close();
pw.println("finished......");
            
}

catch(Exception e){ 
       
   }
} 
}

 