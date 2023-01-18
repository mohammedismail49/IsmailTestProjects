package employeeDatabase;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class updateservlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public updateservlet2() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType ("text/html");
	        PrintWriter out = response.getWriter ();
	        String sid = request.getParameter ("id");
	        int id = Integer.parseInt (sid);
	        String name = request.getParameter ("name");
	        String dept = request.getParameter ("dept");
	        Emp e = new Emp ();
	        e.setId (id);
	        e.setName (name);
	        e.setDept (dept);
	        int status = empoperation.update (e);
	        if (status > 0)
	        {
	         out.println ("Record updated succesfully...");
	         response.sendRedirect ("viewservlet");
	        }
	        else
	        {
	         out.println ("Sorry! unable to update record");
	        }
	        out.close ();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType ("text/html");
	        PrintWriter out = response.getWriter ();
	        String sid = request.getParameter ("id");
	        int id = Integer.parseInt (sid);
	        String name = request.getParameter ("name");
	        String dept = request.getParameter ("dept");
	        Emp e = new Emp ();
	        e.setId (id);
	        e.setName (name);
	        e.setDept (dept);
	        int status = empoperation.update (e);
	        if (status > 0)
	        {
	         out.println ("Record updated succesfully...");
	         response.sendRedirect ("viewservlet");
	        }
	        else
	        {
	         out.println ("Sorry! unable to update record");
	        }
	        out.close ();
	}

}
