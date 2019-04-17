package com.uwimana;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculator"})
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                PrintWriter out = response.getWriter();
        try {
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            String num3 = request.getParameter("num3");
            String num4 = request.getParameter("num4");

            if(!("".equals(num1) && "".equals(num2))){
                out.print(num1 + " + " + num2 + " = ");
                out.print(Integer.valueOf(num1) + Integer.valueOf(num2));
                out.println();
            }

            if(!("".equals(num3) && "".equals(num4))){
                out.print(num3 + " * " + num4+ " = ");
                out.print(Integer.valueOf(num3) * Integer.valueOf(num4));
            }

        }catch (Exception e){
            out.print("Something is wrong...");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
