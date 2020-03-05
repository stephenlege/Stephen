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
@Named(value = "simpleBean")
@RequestScoped
public class SimpleBean {

    String [] colors = {"red", "orange", "yellow"};

   public String getColor(int index){
       return colors[index];
   }

    public String[] getColors() {
        return colors;
    }

    
    public SimpleBean() {
    }
           
    
    public String getMessage(){
        return ("Hello");
    }
}
