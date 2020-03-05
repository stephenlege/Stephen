package edu.slcc.asdv.bean;

import edu.slcc.asdv.bl.Quiz;
import java.io.Serializable;

import javax.inject.Named; 
   // or import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped; 
   // or import javax.faces.bean.SessionScoped;

@Named (value ="quizBean")
@SessionScoped
public class QuizBean implements Serializable {
   //private ArrayList<MathSequence> problems = new ArrayList<MathSequence>();     
   private int scoreOut;
   private String answer;
   private String question;
   Quiz quiz;//placeholder
   
   private String isEnLocale;
   
   public QuizBean() {      
       quiz = new Quiz();
   }   
   public String eraseAnswer(){
        return answer = "";}
        
    public int getScoreOut() {
        return scoreOut;
    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        question = quiz.quizCurrentQuestion();
        return question;
        
    }

    public Quiz getQuiz() {
        return quiz;
    }

   
    public void setScoreOut(int scoreOut) {
        this.scoreOut = scoreOut;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
        scoreOut = quiz.calculateScore(answer);
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setIsEnLocale(String isEnLocale) {
        this.isEnLocale = isEnLocale;
        quiz.changeLocale(isEnLocale);
    }

    public String getIsEnLocale() {
        return isEnLocale;
    }

   

     
}
