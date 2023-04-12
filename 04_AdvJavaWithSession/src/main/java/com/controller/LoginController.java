package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.utils.DBUtil;
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// check connectivity using @webservlet
				System.out.println("Login controller called");

				//setp 1 : get data from jsp form
				String email = request.getParameter("email");
				String pass = request.getParameter("password");
				System.out.println(email);
				System.out.println(pass);

				// step 2 : process data
				
				
				// play with session
				HttpSession session=request.getSession();
				System.out.println("Printing session Id first time ");
				System.out.println(session.getId());
				
				if(!session.isNew())
				{
					System.out.println("Session Invalidate(Destroy current session)");
					session.invalidate();
					session=request.getSession();
					session.setMaxInactiveInterval(0);
				}
				
				//Print current session Id of our browser
				//Print session Id we have getId method 
				System.out.println("Printing session Id after invalidate ");
				System.out.println(session.getId());
				System.out.println("Printing session creation time");
				System.out.println(session.getCreationTime());
				
				
				//Process data

				// Write select query for check user is present or not
				try {
					Connection con = DBUtil.getMySQLConnection();
					PreparedStatement ps = con.prepareStatement("Select * FROM login where email = ? AND password = ? ;");
					ps.setString(1, email);
					ps.setString(2, pass);
					ResultSet rs = ps.executeQuery();
					RequestDispatcher rd = null;

					// step 3 : navigate data
					if (rs.next()) {
						System.out.println("User found !");
						//get valid user data
						System.out.println(rs.getInt(1));
						System.out.println(rs.getString(2));
						
						//set user id and email in session
						// for that we have setAttributeMethod
						
						session.setAttribute("userIdInSession", rs.getInt(1));
						session.setAttribute("userEmailInSession", rs.getString(2));
						
						System.out.println("=================================");
						
						System.out.println(session.getAttribute("userIdInSession"));
						System.out.println(session.getAttribute("userEmailInSession"));
						
						response.sendRedirect("dashboard.jsp");
						//rd=request.getRequestDispatcher("dashboard.jsp");
						//rd.forward(request, response);
					} else {
						System.out.println("User not found !");
						request.setAttribute("errormessage", "Invalid Email and Password");
						rd = request.getRequestDispatcher("index.jsp");
						rd.forward(request, response);
					}
					con.close();
				} catch (Exception e) {
					System.out.println("Error while execute query");
				}
				
	}

}
