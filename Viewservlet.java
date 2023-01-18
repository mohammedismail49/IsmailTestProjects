package employeeDatabase;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class Viewservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Viewservlet() {
        super(); 
        
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   response.setContentType ("text/html");
	        PrintWriter out = response.getWriter ();
	        out.println ("<a href='Index.html'>Add Employee</a>");
	        out.println ("<h1>Employees List</h1>");
	        List <Emp> list = empoperation.getAllEmployees();
	        out.print ("<table border='1' width='100%' ");
	        out.print("<tr><th>Id</th><th>Name</th><th>Dept</th><th>Update</th><th>Delete</th></tr>");

	        for (Emp e:list)
	        {
	         out.print ("<tr><td>" + e.getId () + "</td><td>" + e.getName () +
	      "</td><td>" + e.getDept () +
	      "</td><td><a href='updateservlet?id=" + e.getId () +
	      "'>update</a></td>  <td><a href='deleteservlet?id=" +
	      e.getId () + "'>delete</a></td></tr>");
	        }
	        out.print ("</table>");
	        out.close ();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   response.setContentType ("text/html");
	        PrintWriter out = response.getWriter ();
	        out.println ("<a href='Index.html'>Add Employee</a>");
	        out.println ("<h1>Employees List</h1>");
	        List <Emp> list = empoperation.getAllEmployees();
	        out.print ("<table border='1' width='100%' ");
	        out.print("<tr><th>Id</th><th>Name</th><th>Dept</th><th>Update</th><th>Delete</th></tr>");

	        for (Emp e:list)
	        {
	         out.print ("<tr><td>" + e.getId () + "</td><td>" + e.getName () +
	      "</td><td>" + e.getDept () +
	      "</td><td><a href='updateservlet?id=" + e.getId () +
	      "'>update</a></td>  <td><a href='deleteservlet?id=" +
	      e.getId () + "'>delete</a></td></tr>");
	        }
	        out.print ("</table>");
	        out.close ();
	}

}
