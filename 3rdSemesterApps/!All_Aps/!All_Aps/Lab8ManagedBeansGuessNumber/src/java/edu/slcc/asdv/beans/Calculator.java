/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "calculator")
@RequestScoped
public class Calculator {
    private double number1;
    private double number2;
    private double answer;

    public double getNumber1() {
        return number1;
    }

    public double getNumber2() {
        return number2;
    }

    public double getAnswer() {
        return answer;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }
    
    
    
    public void add(){
         answer = number1 + number2;
    }
    
    public void subtract(){
         answer = number1 - number2;
    }
    
    public void multiply(){
         answer = number1 * number2;
    }
    public void divide(){
         answer = number1 / number2;
    }
    
    public void reset(){
        number1 = 0;
        number2 = 0;
        answer = 0;
    }
   
    public Calculator() {
    }
    
}
