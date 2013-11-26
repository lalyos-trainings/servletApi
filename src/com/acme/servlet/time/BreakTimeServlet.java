package com.acme.servlet.time;

import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BreakTimeServlet
 */
public class BreakTimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BreakTimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    private TreeSet<String> getBreakTimes() {
        TreeSet<String> breaktimes = (TreeSet<String>) getServletContext().getAttribute("breakTimes");
        if (breaktimes == null) {
            breaktimes = new TreeSet<>();
            getServletContext().setAttribute("breakTimes", breaktimes);
        }
        
        return breaktimes;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    printList(request, response);
	}


    private void printList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        String highlite = request.getParameter("break");

        
        response.setContentType("text/html");
        response.getWriter().println("<h2>List of breaks</h2>");
        response.getWriter().println("<ul>");
        
        for (String nextBreak : getBreakTimes()) {
            if ( nextBreak.equals(highlite)) {
                response.getWriter().println("<li style='background: green;'>" + nextBreak  + "</li>");
            } else {
                response.getWriter().println("<li>" + nextBreak  + "</li>");                
            }
        }
        
        response.getWriter().println("</ul>");
        
        response.getWriter().println("<h2>Add new break time</h2>");
        response.getWriter().println("<form action=\"breaktime\" method=\"post\">");
        response.getWriter().println("  <input type=\"text\" name=\"break\" />");
        response.getWriter().println("  <input type=\"submit\" value=\"add\">");
        response.getWriter().println("</form>");
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/footer");
        dispatcher.include(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextBreak = request.getParameter("break");
	    getBreakTimes().add(nextBreak);
	    printList(request, response);

	}

}