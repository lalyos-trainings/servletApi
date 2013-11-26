package com.acme.servlet.time;

import java.util.TreeSet;

import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {

    public BaseServlet() {
        super();
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