package com.acme.servlet.time;

import java.io.IOException;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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



    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        
        super.service(request, response);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/footer");
        dispatcher.include(request, response);
    }

}