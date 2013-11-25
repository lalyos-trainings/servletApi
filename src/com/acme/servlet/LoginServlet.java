package com.acme.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = URLEncoder.encode(request.getParameter("username"), "UTF8");
				
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		response.setContentType("text/html");
		
		response.getWriter().println("<h1>Hello " + username + "</h1>");

        response.getWriter().println("<hr/><a href=\"" + getServletContext().getContextPath() + "\" >home</a>");

	}

}
