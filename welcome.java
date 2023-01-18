package req;

 

import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.PrintWriter;

 

 

public class welcome extends HttpServlet {

private static final long serialVersionUID = 1L;

 

 

public welcome() {

super();

 

}

 

 

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

 

response.setContentType("text/html;charset=UTF-8");

PrintWriter out =response.getWriter();

try{

out.println("<!DOCTYPE html>\r\n"

+ "<html>\r\n"

+ "<head>\r\n"

+ " <title>Login Success</title>\r\n"

+ " <style>\r\n"

+ " /* Add some basic styling for the body */\r\n"

+ " body {\r\n"

+ " background-color: #f0f0f0;\r\n"

+ " font-family: Arial, sans-serif;\r\n"

+ " }\r\n"

+ " /* Add some spacing and a border to the message container */\r\n"

+ " .message {\r\n"

+ " font-size: larger;\r\n"

+ " font-weight: bold;\r\n"

+ " color: green;\r\n"

+ " text-align: center;\r\n"

+ " margin: 50px;\r\n"

+ " padding: 20px;\r\n"

+ " border: 1px solid green;\r\n"

+ " border-radius: 5px;\r\n"

+ " }\r\n"

+ " /* Add a button with some styling */\r\n"

+ " .message button {\r\n"

+ " background-color: green;\r\n"

+ " color: white;\r\n"

+ " font-size: medium;\r\n"

+ " padding: 10px 20px;\r\n"

+ " border: none;\r\n"

+ " border-radius: 5px;\r\n"

+ " margin-top: 20px;\r\n"

+ " }\r\n"

+ " /* Add a hover effect to the button */\r\n"

+ " .message button:hover {\r\n"

+ " cursor: pointer;\r\n"

+ " background-color: darkgreen;\r\n"

+ " }\r\n"

+ " </style>\r\n"

+ "</head>\r\n"

+ "<body>\r\n"

+ " <div class=\"message\">\r\n"

+ " <h2>Logged in successfully</h2>\r\n"

+ " <p>Welcome, Mohammed Ismail Zabiullah</p>\r\n"

+ " <button>Go to Dashboard</button>\r\n"

+ " </div>\r\n"

+ "</body>\r\n"

+ "</html>\r\n"

+ "");

}

finally{

out.close();

}

}

 

 

}