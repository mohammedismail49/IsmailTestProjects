package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/authenticate")
public class mvcServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public mvcServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
response.setContentType("text/html");
MVCBEAN obj = new MVCBEAN();
obj.setUsername(request.getParameter("username"));
obj.setUserpassword(request.getParameter("userpassword"));

if(obj.validate()) {
	RequestDispatcher rd = request.getRequestDispatcher("oklogin.jsp");
	rd.forward(request, response);
}
else {
	RequestDispatcher rd = request.getRequestDispatcher("notlogin.jsp");
	rd.forward(request, response);
}
		
		
	}

}
