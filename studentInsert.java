package student;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class studentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public studentInsert() {
        super();
       
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ismail","ismail","miz@4499");
			
			System.out.println("Inserting records into the table...");
			String s = "INSERT INTO student VALUES(? , ? , ?)";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setInt(1 , Integer.parseInt(request.getParameter("stdno")));
			pstmt.setString(2 , request.getParameter("stdname"));
			pstmt.setInt(3 , Integer.parseInt(request.getParameter("stdfee")));
			int count = pstmt.executeUpdate();
			
			PrintWriter out = response.getWriter();
			pstmt.close();
			con.close();
			out.println("<h1>"+count+" Data inserted sucessfully</h1>");
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
	}

}
