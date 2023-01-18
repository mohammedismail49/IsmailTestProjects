package bitlabs.ServletExample;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloWorld extends HttpServlet {
	
       
   
   
	private static final long serialVersionUID = 1L;


	public HelloWorld() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		PrintWriter out = response.getWriter();
		out.println("Hello, World!");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		PrintWriter out = response.getWriter();
		out.println("Hello, World!");
		
	}

}
