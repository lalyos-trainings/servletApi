package com.acme.servlet.time;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NextBreak
 */
public class NextBreak extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
    private static final SimpleDateFormat hourFormatter = new SimpleDateFormat("HH:mm");
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd ");
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NextBreak() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TreeSet<String> breakTimes = getBreakTimes();
		
		Date now = new Date();
        String nowHours = hourFormatter.format(now);
        String nowDate = dateFormatter.format(now);
		String nextBreak = breakTimes.higher(nowHours);
		
		if (nextBreak != null) {
		    try {
                Date breakTime = sdf.parse(nowDate + nextBreak);
                long minutes = (breakTime.getTime() - now.getTime()) / 60000;
                
                response.getWriter().println("<h1>Break Time</h1>");

                response.getWriter().println("<div class='msg'>");
                response.getWriter().println(minutes + " minutes left");
                response.getWriter().println("</div>");

            } catch (ParseException e) {
                log("date error with: " + nextBreak);
            }
		    
		} else {
            response.getWriter().println("<h1>No Break Time ...</h1>");
		}
		
	}

}
