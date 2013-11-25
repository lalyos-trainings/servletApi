package com.acme.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
				
		List<String> list = (List<String>) getServletContext().getAttribute("userList");
		if (list == null) {
		    list = new ArrayList<String>();
		    getServletContext().setAttribute("userList", list);
		}
		
		list.add(username);
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		response.setContentType("text/html");
		
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/home");
        dispatcher.include(request, response);

	}

}
