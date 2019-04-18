package com.uwimana;

import java.util.Random;

public class Quiz {

    private static String [] questions = {
            "3,1,4,1,5",
            "1,1,2,3,5",
            "1,4,9,16,25",
            "2,3,5,7,11",
            "1,2,4,8,16"
    };

    private static int[] answers = {9,8,36,13,32};

    private int index;

    private int score;

    public Quiz(){
        index = 0;
        score = 0;
    }

    public  String[] getQuestions() {
        return questions;
    }

    public  int[] getAnswers() {
        return answers;
    }

    public String getNextQuestion(){
        String question = "";
        if (index<questions.length){
            question =  questions[index];
            index = index+1;
        }else{
            question= null;
        }
        return question;
    }
    public void checkAnswer(int answer){

        if (answer== answers[index-1]){
            score = score + 1;
        }
    }

    public int getScore(){
        return score;
    }

    public int getNextIndex(){
        return index;
    }
}
