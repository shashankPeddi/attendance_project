<html>
<head>
<style>
table{
  background-color: rgba(0,0.5,1,0.5);
  margin: 0 auto;
  margin-top: 10px;
  padding-top: 25px;
padding-left: 25px;
padding-right: 25px;
padding-bottom: 25px;
  -webkit-border-color: 15px;
  -moz-border-color: 15px;
  -ms-border-color: 15px;
  -o-border-color: 15px;
  /*border-color: 15px;*/
  color:white;
  font-weight: bolder;
  -webkit-box-shadow: inset -6px -6px rgba(0,0,0,0.5);
  box-shadow: inset -4px -4px rgba(0,0,0,0.5);
  font-size: 18px;
text-decoration:none;
}
body{
background-color:grey;
border:7px inset blue;
}
a{
color:white;
}
a:link,td:visited {
text-align:center;
text-decoration: none;
color:black;
    text-align: center; 
    text-decoration: none;
    display: inline-block;
	scrolling:"no";
}
a:hover,td:active {
    
 background: red;
}

</style>
</head>
<marquee><a href="quizlogin.html">Quiz</a></marquee>
<body>

<%@ page import="java.sql.*" %>

<%
String name=request.getParameter("tf1");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wt_ext","root","root");
if(con!=null)
out.println("");
else
out.println("not ok");
PreparedStatement pst1=con.prepareStatement("select * from cse_c_attendance where date_time="+"'"+name+"'");
ResultSet rst=pst1.executeQuery();
PreparedStatement pst=con.prepareStatement("select Current_date");
ResultSet rst1=pst.executeQuery();
%>
<center>
<table id="id1">
<% while(rst1.next()){ %>
<tr><td>Todays Date is:<%=rst1.getString(1)%></td>
<%
}
%>

</table>

<table border="10">
<% while(rst.next()){ %>
<tr>
<td>Date</td>
<td>Period</td>
<td>Comments</td>
<td>Absenteez</td>
</tr>
<tr><td><%=rst.getString(3)%></td>

<td><%=rst.getString(2)%></td>

<td><%=rst.getString(1)%></td>

<td><%=rst.getString(4)%></td></tr>

<%
}
%>
</table>
</center>
<a href="dis.jsp">see details for some other day</a></br>
<a href="studentlogin.html">Go back to login</a></br>
<a href="http://localhost:2018/wtexternal">Back to main page</a></br>
<%
}
catch(Exception e)
{
}
%>
</body>
</html>