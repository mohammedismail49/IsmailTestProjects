package com;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;


	public class UserDao {
	 Connection con;
		public UserDao(){
			try {
				Class.forName("com.mysql.jdbc.Driver");  
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ismail","ismail","miz@4499");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}
		
		public boolean validate(String gmail, String password) {
			
			try {
				
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from HusersAdd");
				while(rs.next()) {
				if(rs.getString(3).equals(gmail) && rs.getString(2).equals(password)) {
					
					return true;
				}
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			return false;
		}
		
		
		public boolean insertInto(SignInPojo pojo) {
			
			
			try {
				PreparedStatement pstmt=con.prepareStatement("INSERT INTO HusersAdd VALUES (?, ?, ?, ?)");
				pstmt.setString(1, pojo.getUsername());
				pstmt.setString(2, pojo.getPassword());
				pstmt.setString(3, pojo.getEmail());
				pstmt.setString(4, pojo.getPhoneNumber());
				
				
				
				int i=pstmt.executeUpdate();
				if(i>0) {
					return true;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
			return false;
			
		}

}
