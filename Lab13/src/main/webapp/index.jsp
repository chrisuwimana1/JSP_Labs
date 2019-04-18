<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<%@ page import="quiz.Quiz" %>

<html>
<body>
<h2>The number quiz</h2>
<%
Quiz quiz=  session.getAttribute("quiz")==null?new Quiz():(Quiz) session.getAttribute("quiz");
%>

<%
    if (quiz.getNextIndex() < quiz.getQuestions().length){


%>
<p>Your current score is <%=quiz.getScore()%></p>
<p> Guess the number in sequence</p>
<p><%= quiz.getNextQuestion()%></p>
<form action ="quiz" method="get">
    Your answer <input type="text" name="answer"><br>
    <input type="submit" value="Submit" name ="submit">
</form>

<%
    }else{
%>
<p>Your current score is <%=quiz.getScore()%></p>
<p> You have completed the quiz with a score of <%= quiz.getScore()%> out of 5</p>
<% } %>
</body>
</html>
