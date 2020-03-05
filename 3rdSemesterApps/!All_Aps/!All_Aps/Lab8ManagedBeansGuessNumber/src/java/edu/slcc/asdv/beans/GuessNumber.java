/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Greg
 */
@Named(value = "guessNumber")
@SessionScoped
public class GuessNumber implements Serializable {

    private int guess;
    private int answer = (int) (Math.random() * 101);
    private String s = "";
    private int remainingGuesses = 10;

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public GuessNumber() {
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    public void checkAnswer() {
        this.s = "";
        --remainingGuesses;

        if (remainingGuesses <= 0) {
            s = "Ran out of guesses, reset run plz";
        }  else if (guess == answer) {
            s = "Correct";
        } else if (guess < answer) {
            s = "too low";
        } else {
            s = "too hight";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(s));
        
    }

    @PostConstruct
    public void reset() {
        this.s = "";
        this.guess = 0;
        this.remainingGuesses = 10;
        this.answer = (int) (Math.random() * 101);

    }
}
