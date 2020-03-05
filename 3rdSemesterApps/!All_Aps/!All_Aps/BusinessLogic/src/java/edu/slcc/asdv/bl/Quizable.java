/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.bl;

/**
 *
 * @author Greg
 */
public interface Quizable {
    
public String quizCurrentQuestion();

public int calculateScore(String answer);
}