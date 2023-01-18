package simple;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/add")
public class adding extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public adding() {
        super();
      
    }


	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		addPOJO obj = new addPOJO();
	
		obj.setNum1(Integer.parseInt(request.getParameter("n1")));
		obj.setNum2(Integer.parseInt(request.getParameter("n2")));
		request.getSession().setAttribute("pojo", obj);
		response.sendRedirect("addme.jsp");
		
	}

}
