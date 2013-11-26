package com.acme.servlet.time;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.loader.StandardClassLoader;
import org.apache.catalina.loader.WebappClassLoader;

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

    private void resourceToResponse(HttpServletResponse response, String resource) {
        
        WebappClassLoader classLoader = (WebappClassLoader) getClass().getClassLoader();
        InputStream stream = classLoader.getResourceAsStream(resource);
        
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
            String line;

            while ( (line = reader.readLine()) != null) {
                response.getWriter().println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        resourceToResponse(response, "header.inc");
        
        super.service(request, response);
        
        resourceToResponse(response, "footer.inc");
    }

}