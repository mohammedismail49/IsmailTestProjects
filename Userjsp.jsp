<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Userjsp.jsp" method = "post">
UserName : <input type="text" name = "username">
<input type = "submit" value = "submit">
</form>
<%=request.getParameter("username")+"@gmail.com"
%>
</body>
</html>
