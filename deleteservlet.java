package employeeDatabase;

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public deleteservlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String sid = request.getParameter ("id");
        int id = Integer.parseInt (sid);
        empoperation.delete (id);
        int status = empoperation.delete (id);
        if (status > 0)
        {
         out.print ("<p>Record deleted successfully!</p>");
         response.sendRedirect ("viewservlet");
        }
        else
        {
         out.println ("Sorry! unable to delete record");
        }
        response.sendRedirect ("viewservlet");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        String sid = request.getParameter ("id");
        int id = Integer.parseInt (sid);
        empoperation.delete (id);
        int status = empoperation.delete (id);
        if (status > 0)
        {
         out.print ("<p>Record deleted successfully!</p>");
         response.sendRedirect ("viewservlet");
        }
        else
        {
         out.println ("Sorry! unable to delete record");
        }
        response.sendRedirect ("viewservlet");
	}

}
