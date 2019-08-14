package com.example.quiz;

public class Questions {

    public  String mQuestions[] = {
            "Where is Great Wall Of China Located?",
            "Where is Petra Located?",
            "Where is Christ the Redeemer Located?",
            "Where is Machu Picchu Located?",
            "Where is Chichen Itza Located?",
            "Where is Colosseum Located?",
            "Which is the Taj Mahal Located?",
            "Which is the Great Pyramid Of Giza Located?"


    };

    private String mChoices[][] = {
            {"China", "Jordan", "Brazil", "Peru"},
            {"Brazil", "Peru", "Jordan", "Mexico"},
            {"Jordan", "Brazil", "Egypt", "Peru"},
            {"Egypt", "Brazil", "Peru", "Mexico"},
            {"China", "Mexico", "India", "Egypt"},
            {"India", "Italy", "Mexico", "Jordan"},
            {"Egypt", "India", "Italy", "Mexico"},
            {"Egypt", "Mexico", "Italy", "India"},



    };
    private String mCorrectAnswers[] = {"China", "Jordan", "Brazil", "Peru","Mexico", "Italy", "India", "Egypt" };

    public String getQuestion(int a){
        String question = mQuestions[a];
        return question;
    }
    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }
    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }
    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }
    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }
    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
