package com.acme.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.acme.servlet.time.BaseServlet;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
	    String username = (String) request.getSession().getAttribute("username");
        if (username == null) {
            username = "Senkihazi";
        }
	    
	    response.getWriter().println("<!DOCTYPE html>");
	    response.getWriter().println("<html>");
	    response.getWriter().println("<head>");
	    response.getWriter().println("<meta charset=\"US-ASCII\">");
	    response.getWriter().println("<title>Insert title here</title>");
	    response.getWriter().println("</head>");
	    response.getWriter().println("<body>");
        response.getWriter().println("  <h1>hello " + username +" </h1>");

        if (request.getSession().getAttribute("username") == null) {
            loginForm(response);
        }

        response.getWriter().println("  <br/><a href=\"nextBreak\">next break</a>");
        response.getWriter().println("  <br/><a href=\"breaktime\">list breaks</a>");
        response.getWriter().println("  <br/><a href=\"users\">list users</a>");
        
        
	    response.getWriter().println("</body>");
	    response.getWriter().println("</html>");	
	

	}

    private void loginForm(HttpServletResponse response) throws IOException {
        response.getWriter().println("  <form action=\"login\" method=\"post\">");
	    response.getWriter().println("      <fieldset>");
	    response.getWriter().println("          <input name=\"username\"  type=\"text\"/>");
	    response.getWriter().println("          <input name=\"password\" type=\"password\" />");
	    response.getWriter().println("          ");
	    response.getWriter().println("          <input type=\"submit\" value=\"login\">");
	    response.getWriter().println("      </fieldset>");
	    response.getWriter().println("  </form>");
	    response.getWriter().println("  ");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
