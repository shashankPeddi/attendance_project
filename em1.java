import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class em1 extends HttpServlet
{
public  void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException 
{ 

   Connection conn = null;
   Statement stmt = null;
   try{ 
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sriram","root","root");
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
         String date=rs.getString("attendance_absent");
         
         bw.append(date); 

	} 
      rs.close();
      bw.close();
   }catch(SQLException se){ 
      se.printStackTrace(); 
   }catch(Exception e){
      e.printStackTrace();
   }finally{ 
      try{ 
         if(stmt!=null)
            conn.close();
      }catch(SQLException se){ 
      } 
      try{ 
         if(conn!=null)
            conn.close();
      }catch(SQLException se){ 
         se.printStackTrace(); 
      } 
   } 
} 
}

  