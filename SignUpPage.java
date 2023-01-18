package com.GHomePack;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.GHomePack.SignUpPage;

/**
 * Servlet implementation class SignUpPage
 */
public class SignUpPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpPage() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		PrintWriter out=response.getWriter();

		out.print("<h1>My first servlet is working yeah!</h1>");

		 

		 

		String user_name=request.getParameter("Usn");

		String pss_wrd=request.getParameter("pwd");

		String repeat_pw=request.getParameter("psw-repeat");

		String user_gmail=request.getParameter("email");

		String user_phno=request.getParameter("phone");

		 out.print("Username : "+user_name);

		try {

		new SignUpPage().insertFormToDataBase(user_name, pss_wrd,repeat_pw, user_gmail, user_phno);

		} catch (ClassNotFoundException | SQLException e) {

		e.printStackTrace();

		}

		 

		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");

		PrintWriter out=response.getWriter();

		out.print("<h1>My first servlet is working yeah!</h1>");

		 

		 

		String user_name=request.getParameter("Usn");

		String pss_wrd=request.getParameter("pwd");

		String repeat_pw=request.getParameter("psw-repeat");

		String user_gmail=request.getParameter("email");

		String user_phno=request.getParameter("phone");

		 out.print("Username : "+user_name);

		try {

		new SignUpPage().insertFormToDataBase(user_name, pss_wrd,repeat_pw, user_gmail, user_phno);

		} catch (SQLException e) {

		e.printStackTrace();

		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}

		 

		}

	public void insertFormToDataBase(String user_name, String pss_wrd, String repeat_pw, String user_gmail, String user_phno) throws ClassNotFoundException, SQLException {

		String query = "INSERT INTO GHomeFORM VALUES ( ? , ? , ? , ? , ? )";

		 

		PreparedStatement pstmt= Concreation.setConnection().prepareStatement(query);

		 

		pstmt.setString(1 , user_name);

		pstmt.setString(2 , pss_wrd);

		pstmt.setString(3 , repeat_pw);

		pstmt.setString(4 , user_gmail);

		pstmt.setString(5 , user_phno);

		 

		 

		int count =pstmt.executeUpdate();

		Concreation.setConnection().close();

		if(count>0)

		System.out.println(count+" row/s effected Successfully");

		else System.out.println("Unable to insert data...");

		 

		}
		
	}


