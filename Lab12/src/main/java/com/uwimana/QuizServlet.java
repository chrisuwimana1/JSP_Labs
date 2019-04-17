package com.uwimana;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;



@WebServlet(name = "QuizServlet", urlPatterns = {"/quiz"})
public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Quiz q;
        if (session.getAttribute("quiz") == null){
             q = new Quiz();
            session.setAttribute("quiz", q );
        }else{
             q = (Quiz) session.getAttribute("quiz");
        }

        int score = 0;

        try{
            String quizAnswer = request.getParameter("answer");
            System.out.println(quizAnswer);

            for (int i = 0 ; i< q.getQuestions().length; i++){
                System.out.println("inside for loop");
                out.println("<h2>The number quiz</h2>");
                out.println("<p>Your current score is "+ score+"</p>");
                out.println("<p> Guess the number in sequence</p>");
                out.println("<p>"+q.getQuestions()[i]+" </p>");
                out.println("<form action =\"quiz\" method=\"post\">");

                if(!("".equals(quizAnswer))){
                    System.out.println("inside if");
                    out.println("Your answer <input type=\"text\" name=\"answer\">");
                    int answer = Integer.valueOf(quizAnswer);
                    if (answer == q.getAnswers()[i]){
                        score++;
                    }

                }else{
                    out.println("Your answer <input type=\"text\" name=\"answer\">");
                }
                out.println("<input type=\"submit\" value=\"Submit\">");
                out.print("</form>");
            }

            out.println("<h2>The number quiz</h2>");
            out.println("<p>Your current score is "+ score+"</p>");
            out.println("<p>You have completed the Number quiz with a score "+ score+" out of 5</p>");

        }catch (Exception e){
            out.print(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
