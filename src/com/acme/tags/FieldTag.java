package com.acme.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FieldTag extends TagSupport {

    private String name;
    
    @Override
    public int doStartTag() throws JspException {

        try {
            pageContext.getOut().println("<div class=\"control-group\">");
            pageContext.getOut().println("  <label class=\"control-label\" for=\"input" + name + "\"> " + name + "</label>");
            pageContext.getOut().println("  <div class=\"controls\">");
            pageContext.getOut().println("    <input type=\"text\" id=\"input" + name + "\" name=\"" + name + "\" placeholder=\"" + name + "\">");
            pageContext.getOut().println("  </div>");
            pageContext.getOut().println("</div>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.doStartTag();        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
