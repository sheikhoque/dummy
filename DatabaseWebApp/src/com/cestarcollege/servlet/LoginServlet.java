package com.cestarcollege.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cestarcollege.util.DatabaseUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			Connection conn = DatabaseUtil.getInstance()
					.getConnection();
		  
			HttpSession session = request.getSession();
			int id=-1;
			try {
				boolean autoCommit = conn.getAutoCommit();
				conn.setAutoCommit(false);
				id = findUser(request, conn, session);
				conn.commit();
			} catch (SQLException e) {
				System.out.println("Error in sql..."+e);
				id=-1;
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			if(id>0){
				response.sendRedirect("profile");
			}else{
				response.sendRedirect("invalidlogin.html");
			}
			
			
			
	}

	private int findUser(HttpServletRequest request, 
			Connection conn, HttpSession session) throws SQLException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String _SELECT_QUERY = new StringBuilder()
				.append(" SELECT * from GROUP_THREE_USER ")
				.append(" WHERE password=? and email=? ")
				.toString();
		PreparedStatement ps = 
				conn.prepareStatement(_SELECT_QUERY);
		ps.setString(1, password);
		ps.setString(2, email);
		ResultSet results = ps.executeQuery();
		int id = -1;
		String firstName = null;
		String lastName = null;
		String gender=null;
		String department = null;
		while(results.next()){
			id = results.getInt("id");
			firstName=results.getString("first_name");
			lastName=results.getString("last_name");
			gender = results.getString("gender");
			department = results.getString("department");
			break;
		}
		
		session.setAttribute("userId", id);
		session.setAttribute("firstName", firstName);
		session.setAttribute("lastName", lastName);
		session.setAttribute("email", email);
		session.setAttribute("gender", gender);
		session.setAttribute("department", department);

		return id;
	}

	
}
