package employeeDatabase;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class reportservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public reportservlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType ("text/html");
	        PrintWriter out = response.getWriter ();
	        String name = request.getParameter ("name");
	        String dept = request.getParameter ("dept");
	        Emp e = new Emp ();
	        e.setName (name);
	        e.setDept (dept);
	        int status = empoperation.save (e);
	        if (status > 0)
	        {
	         out.print ("<p>Record saved successfully!</p>");
	         request.getRequestDispatcher ("Index.html").include (request, response);
	        }
	        else
	        {
	         out.println ("Sorry! unable to save record");
	        }
	        out.close ();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 response.setContentType ("text/html");
	        PrintWriter out = response.getWriter ();
	        String name = request.getParameter ("name");
	        String dept = request.getParameter ("dept");
	        Emp e = new Emp ();
	        e.setName (name);
	        e.setDept (dept);
	        int status = empoperation.save (e);
	        if (status > 0)
	        {
	         out.print ("<p>Record saved successfully!</p>");
	         request.getRequestDispatcher ("Index.html").include (request, response);
	        }
	        else
	        {
	         out.println ("Sorry! unable to save record");
	        }
	        out.close ();
		
	}

}
