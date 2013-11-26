package com.acme.servlet.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteBreakServlet
 */
public class DeleteBreakServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBreakServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String breakToDelete = request.getParameter("break");
		if (breakToDelete != null) {
		    getBreakTimes().remove(breakToDelete);
		}
		
		response.sendRedirect(getServletContext().getContextPath() + "/breaktime");
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String requestURI = request.getRequestURI();
	    int lastIndexOf = requestURI.lastIndexOf("/");
	    
	    String breakToDelete = requestURI.substring(lastIndexOf + 1);
        
        if (breakToDelete != null) {
            getBreakTimes().remove(breakToDelete);
            response.getWriter().println("{'result':'ok'}");
        }
	}

    protected TreeSet<String> getBreakTimes() {
        TreeSet<String> breaktimes = (TreeSet<String>) getServletContext().getAttribute("breakTimes");
        if (breaktimes == null) {
            breaktimes = new TreeSet<>();
            getServletContext().setAttribute("breakTimes", breaktimes);
        }
        
        return breaktimes;
    }

}
