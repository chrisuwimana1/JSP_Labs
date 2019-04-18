package quiz;

import quiz.Quiz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/quiz")
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

        Quiz q=  session.getAttribute("quiz")==null?new Quiz():(Quiz) session.getAttribute("quiz");
        if (submit != null && quizAnswer != null) {
            //q = (Quiz) session.getAttribute("quiz");
            if (!("".equals(quizAnswer))) {
                q.checkAnswer(Integer.valueOf(quizAnswer));
            }

        }
        session.setAttribute("quiz", q);
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}


