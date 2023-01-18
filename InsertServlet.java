package com;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public InsertServlet() {
        super();
        
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = new UserDao();
		SignInPojo pojo = new SignInPojo();
		
		
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("phone"));
		
		pojo.setUsername(request.getParameter("name"));
		pojo.setEmail(request.getParameter("email"));
		pojo.setPassword(request.getParameter("password"));
		pojo.setPhoneNumber(request.getParameter("phone"));
		
		boolean done = dao.insertInto(pojo);
		
		if(done) {
			try {
				PrintWriter pw=response.getWriter();
				pw.println("<body><h1> registration successful </h1><body>");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				PrintWriter pw=response.getWriter();
				pw.println("<body><h1> registration unsuccessful</h1><body>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
