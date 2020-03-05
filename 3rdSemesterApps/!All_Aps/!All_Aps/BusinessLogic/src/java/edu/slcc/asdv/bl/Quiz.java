/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

/**
 *
 * @author Greg
 */
public class Quiz implements Quizable, Localable, Serializable {

    private ArrayList<MathSequence> problems = new ArrayList<>();
    private int currentIndex = 0;
    private int score = 0;
    private String userCurrentAnswer = "";

    private String isEnLocale = "en";

    public Quiz() {
        problems.add(new MathSequence(new int[]{3, 1, 4, 1, 5}, 9)); // pi
        problems.add(new MathSequence(new int[]{1, 1, 2, 3, 5}, 8)); // fibonacci
        problems.add(new MathSequence(new int[]{1, 4, 9, 16, 25}, 36)); // squares
        problems.add(new MathSequence(new int[]{2, 3, 5, 7, 11}, 13)); // primes
        problems.add(new MathSequence(new int[]{1, 2, 4, 8, 16}, 32)); // powers of 2
    }

    public String getUserCurrentAnswer() {
        return userCurrentAnswer;
    }

    public void setScore(int score) {
        this.score = score;
    }

    

    public void setUserCurrentAnswer(String userCurrentAnswer) {
        this.userCurrentAnswer = userCurrentAnswer;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String quizCurrentQuestion() {
        return problems.get(currentIndex).getSequence().toString();
    }

    @Override
    public int calculateScore(String answer) {
        try {
            if (String.valueOf(problems.get(currentIndex).getSolution())
                    .equals(answer.trim())) {
                currentIndex = (currentIndex + 1) % problems.size();
                
                return ++score;
            }
            
        } catch (NumberFormatException ex) {
            System.out.println(ex);
        }
        currentIndex = (currentIndex + 1) % problems.size();
        return score;
    }

    @Override
    public Locale locale() {
         UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();     
        return new Locale(isEnLocale);

    }

    @Override
    public String changeLocale(String localeAcronym) {
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();

        if (isEnLocale == "en") {
            viewRoot.setLocale(new Locale("de"));
            isEnLocale = "de";
            return (isEnLocale);
        } else {
            viewRoot.setLocale(new Locale("en"));
            isEnLocale = "en";
            return (isEnLocale);
        }
    }
}
