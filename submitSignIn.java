package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




public class submitSignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public submitSignIn() {
        super();
        
    }

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String gmail=request.getParameter("email");
		String passwrd=request.getParameter("password");
		
		System.out.println(gmail);
		System.out.println(passwrd);
		
		UserDao obj=new UserDao();
		boolean b=obj.validate(gmail,passwrd);
		if(b) {
			try {
				PrintWriter pw=response.getWriter();
				pw.println("<body><h1> valid user </h1><body>");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				PrintWriter pw=response.getWriter();
				pw.println("<body><h1> Invalid user </h1><body>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
