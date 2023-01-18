package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/et" , 
initParams = {
		@WebInitParam(name = "first"  , value = "second")
})

public class s extends HttpServlet {

private static final long serialVersionUID = 1L;

 

public s() {

super();

// TODO Auto-generated constructor stub

}

 

 

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

int a=Integer.parseInt(request.getParameter("p"));

PrintWriter i=response.getWriter();

i.println(a);
i.println(getInitParameter("first"));

}

 

 

}

 