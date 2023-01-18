<%@ page import = "java.io.*,java.util.*,java.sql.*,java.sql.DriverManager"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 


try{
	//Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ismail","ismail","miz@4499");
	Statement stmt = con.createStatement();
	
	ResultSet rs = stmt.executeQuery("select * from student");
	while(rs.next()){
		%>
<%= rs.getString(2)%><br>
<%
	}
	rs.close();
	con.close();
}
catch(Exception e){
	e.printStackTrace();
}


%>
</body>
</html>