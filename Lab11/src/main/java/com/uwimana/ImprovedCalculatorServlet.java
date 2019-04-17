package com.uwimana;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "ImprovedCalculatorServlet" , urlPatterns = {"/improvedcalculator"})
public class ImprovedCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            String num3 = request.getParameter("num3");
            String num4 = request.getParameter("num4");

            out.println("<form action='improvedcaculator'>");
            if(!("".equals(num1) && "".equals(num2))){
                int sum = Integer.valueOf(num1) + Integer.valueOf(num2);
                out.println(" <input name=\"num1\" value="+num1+"> + <input name=\"num2\" value="+num2+"> = <input name=\"sum\" value="+sum+" readonly>");
                out.println();
            }else{
                out.println("<input name=\"num1\"> + <input name=\"num2\"> = <input name=\"sum\" readonly>");
                out.println();
            }
            out.print("<br/>");
            if(!("".equals(num3) && "".equals(num4))){
                int product = Integer.valueOf(num3) * Integer.valueOf(num4);
                out.println("<input name=\"num3\" value="+num3+"> * <input name=\"num4\" value="+num4+"> = <input name=\"product\" value="+product+" readonly>");
            }else{
                out.println("<input name=\"num3\"> * <input name=\"num4\"> = <input name=\"product\" readonly>");
            }
            out.print("<br/>");
            out.print(" <input type=\"submit\" value=\"Submit\" >");
            out.print("</form>");

        }catch (Exception e){
            out.print("Something is wrong...");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
