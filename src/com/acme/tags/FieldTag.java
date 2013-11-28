package com.acme.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class FieldTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        try {
            pageContext.getOut().println("<h3>Field tag  ...</h3>");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return super.doStartTag();        
    }

    
}
