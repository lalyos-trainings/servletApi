package com.acme.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Headerservlet
 */
public class Headerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Headerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<div>");
        response.getWriter().println("<a href=\"home\">BreakTime</a>");
        response.getWriter().println("<a href=\"nextBreak\">[next break]</a>");
        response.getWriter().println("<a href=\"breaktime\">[list breaks]</a>");
        response.getWriter().println("<a href=\"users\">[list users]</a>");
        response.getWriter().println("</div>");
	}

}
