package com.cestarcollege.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		int userId = (Integer)session.getAttribute("userId");
		String firstName = (String)session.getAttribute("firstName");
		String lastName = (String)session.getAttribute("lastName");
		String email = (String)session.getAttribute("email");
		String gender = (String)session.getAttribute("gender");
		String department = (String)session.getAttribute("department");
		response.getWriter().append("<html> <head></head> <body>")
			.append("<table>")
			.append("<tr><td>User ID </td><td>"+userId+"</td></tr>")
			.append("<tr><td>First Name: </td><td>"+firstName+"</td></tr>")
			.append("<tr><td>Last  Name: </td><td>"+lastName+"</td></tr>")
			.append("<tr><td>email</td><td>"+email+"</td></tr>")
			.append("<tr><td>gender</td><td>"+gender+"</td></tr>")
			.append("<tr><td>department</td><td>"+department+"</td></tr>")
			.append("</table></body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
