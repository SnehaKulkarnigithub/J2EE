package com.advj.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet1")
@WebInitParam(name = "dbdriver", value = "com.jdbc.odbc.driver") 

public class AdminServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Sets the content type of the response being sent to the client,
		response.setContentType("text/html");
		/*the method just returns the default value ISO-8859-1), getWriterupdates it to 
		ISO-8859-1 */
		PrintWriter out = response.getWriter();
		out.print("welcome ADMIN welcome to servlet");
		out.close();

		// once the value set in 
		//a ServletContext object, used by the caller to interact with its servlet container
		ServletContext servletContext = getServletContext();
		/*a String containing the value of the context's initialization parameter, 
		or null if the context's initialization parameter does not exist */
		System.out.println(servletContext.getInitParameter("dbdriver"));
		


	}
}