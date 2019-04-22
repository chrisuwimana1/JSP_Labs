package com.uwimana;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTime extends SimpleTagSupport {
    String color;
    String size;

    // render custom tag
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        out.write("<span style=\"color: red; font-size: 12px;\">"+ft.format(dNow)+"</span>");

    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
