package com.acme.servlet;

import java.io.IOException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BreakServlet
 */
public class BreakServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private Date coffeTime;
    private MessageFormat msgFormat;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BreakServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            coffeTime = sdf.parse(config.getInitParameter("breakTime"));
            msgFormat = new MessageFormat(config.getInitParameter("breakMessageFormat"));

        } catch (Exception e) {
            log("Date Format error ...");
        }

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        ServletContext context = getServletContext();
        
        Date now = new Date();
        long minutes = (coffeTime.getTime() - now.getTime()) / 60000;
        Object[] objs = {minutes};

        
        response.getWriter().println("Breakservlet ...");
        response.getWriter().println("<h1>Time</h1>");
        response.getWriter().println("<div>");
        response.getWriter().println(msgFormat.format(objs));
        response.getWriter().println("</div>");

    }

}
