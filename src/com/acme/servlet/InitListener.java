package com.acme.servlet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class InitListener
 *
 */
public class InitListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitListener() {
        // TODO Auto-generated constructor stub
    }

    public void contextInitialized(ServletContextEvent ctxEvent) {
        ServletContext ctx = ctxEvent.getServletContext();

        TreeSet<String> breaktimes = new TreeSet<>();
        ctx.setAttribute("breakTimes", breaktimes);
        ctx.setAttribute("userList", new ArrayList<String>());

        String breaks = ctx.getInitParameter("defaultBreaks");
        breaktimes.addAll(Arrays.asList(breaks.split(",")));            
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
