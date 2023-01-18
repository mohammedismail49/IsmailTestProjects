<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="simple.addPOJO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>adding bro</title>
</head>
<body>

<% 
int n1 = ((addPOJO)request.getSession().getAttribute("pojo")).getNum1();
int n2 = ((addPOJO)request.getSession().getAttribute("pojo")).getNum2();
%>
<%=n1+n2 %>
</body>
</html>