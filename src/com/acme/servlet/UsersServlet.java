package com.acme.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.servlet.time.BaseServlet;

/**
 * Servlet implementation class UsersServlet
 */
public class UsersServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> list = (List<String>) getServletContext().getAttribute("userList");
        if (list == null) {
            list = new ArrayList<String>();
            getServletContext().setAttribute("userList", list);
        }
        
        response.getWriter().println("<h1>Logged in users</h1>");
        response.getWriter().println("<ul>");
        
        for (String nextuser : list) {
            response.getWriter().println("<li>" + nextuser + "</li>");            
        }
        
        response.getWriter().println("</ul>");

	}

}
