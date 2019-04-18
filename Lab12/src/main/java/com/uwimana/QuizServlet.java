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

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String submit = request.getParameter("submit");
        String quizAnswer = request.getParameter("answer");

        System.out.println("submit " + submit);
        System.out.println("answer " + quizAnswer);

        HttpSession session = request.getSession();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Quiz q;
        if (submit != null && quizAnswer != null) {
            q = (Quiz) session.getAttribute("quiz");
            if (!("".equals(quizAnswer))) {
                System.out.println("current index " + q.getNextIndex());
                q.checkAnswer(Integer.valueOf(quizAnswer));
            } else {
                //out.println("Your answer <input type=\"text\" name=\"answer\">");
            }

        } else {
            q = new Quiz();
            session.setAttribute("quiz", q);
            System.out.println(q.getNextIndex());
        }
        if (q.getNextIndex() < q.getQuestions().length) {
            out.println("<html>");
            out.println("<body>");
            out.println("<h2>The number quiz</h2>");
            out.println("<p>Your current score is " + q.getScore() + "</p>");
            out.println("<p> Guess the number in sequence</p>");
            out.println("<p>" + q.getNextQuestion() + " </p>");
            System.out.println(q.getNextIndex());

            out.println("<form action =\"quiz\" method=\"get\">");
            out.println("Your answer <input type=text name=answer>");
            out.println("<input type=submit value=Submit name=submit>");
            out.print("</form>");
            out.println("</body>");
            out.println("</html>");
        } else {
            out.println("<h2>The number quiz</h2>");
            out.println("<p>Your current score is " + q.getScore() + "</p>");
            out.println("<p>You have completed the Number quiz with a score " + q.getScore() + " out of 5</p>");
        }
    }
}


