package com.GHomePack;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class LoginPage
 */
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginPage() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print("Login servlet running");
		
		
		//check if user name and password available in database
		
		String check_UN =request.getParameter("l-usr-nm");
		String check_pw =request.getParameter("l-psw");
		
		String query="SELECT username FROM GHomeFORM WHERE dusername=? AND dpassword=?";
		
		try {
			PreparedStatement pstmt = Concreation.setConnection().prepareStatement(query);
			pstmt.setString(1, check_UN);
			pstmt.setString(2, check_pw);
			ResultSet rs = pstmt.executeQuery();
	        boolean flag = false;
	        while(rs.next()){
	            //write a code to display column name
	            System.out.println(rs.getString(1)+rs.getString(2));
	            flag=true;
	            out.println("Valid");
	        }
	        rs.close();
	        Concreation.setConnection().close();
	        if(!flag) {
	        	out.print("Invalid");
	        	System.out.println("Unable to fetch data/data not available");
	        }

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
		out.print("Login servlet running");
		
		
		//check if use rname and password available in database
		
		String check_UN =request.getParameter("l-usr-nm");
		String check_pw =request.getParameter("l-psw");
		
		String query="SELECT username FROM GHomeFORM WHERE dusername=? AND dpassword=?";
		
		try {
			PreparedStatement pstmt = Concreation.setConnection().prepareStatement(query);
			pstmt.setString(1, check_UN);
			pstmt.setString(2, check_pw);
			ResultSet rs = pstmt.executeQuery();
	        boolean flag = false;
	        while(rs.next()){
	            //write a code to display column name
	            System.out.println(rs.getString(1)+rs.getString(2));
	            flag=true;
	            out.println("Valid");
	        }
	        rs.close();
	        Concreation.setConnection().close();
	        if(!flag) {
	        	out.print("Invalid");
	        	System.out.println("Unable to fetch data/data not available");
	        }

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		
	}

}
