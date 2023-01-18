package sample;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Add() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.valueOf(request.getParameter("n1"));
		int b = Integer.valueOf(request.getParameter("n2"));
		int c = a + b ;
		
		PrintWriter out = response.getWriter();
		out.println("Addition of "+a+" and "+b+"is "+c);
if(c%2==0) {
	out.println("<h1> "+c+" is even</h1>");
		}
		else {
			out.println("<h1> "+c+" is odd</h1>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int a = Integer.valueOf(request.getParameter("n1"));
		int b = Integer.valueOf(request.getParameter("n2"));
		int c = a + b ;
		PrintWriter out = response.getWriter();
		out.println("<h1>Addition of "+a+" and "+b+" is "+c+"</h1>");
		if(c%2==0) {
			out.println("<h1> "+c+" is even</h1>");
				}
				else {
					out.println("<h1> "+c+" is odd</h1>");
				}
	}

}
