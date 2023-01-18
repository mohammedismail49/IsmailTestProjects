package req;

 

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

 

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

 


public class validate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public validate() {
        super();

    }

 



 

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out =response.getWriter();
            try{
            String name =request.getParameter("user");
            String password =request.getParameter("pass");

 

     

 

            if(password.equals("abc"))
            {
            RequestDispatcher rd=request.getRequestDispatcher("welcome");
            // transfer control to another servlet with URL value " Welcome":
            rd.forward(request, response);
            }
            else
            {
           // out.println("<font color='red'><b>You have entered incorrect password</b></font>");
           // RequestDispatcher rd=request.getRequestDispatcher("index.html");
           // rd.include(request, response);

            response.sendRedirect("index.html");

            }
            }
            finally{
            out.close();
            }

 

     

 

            

    }

 

}