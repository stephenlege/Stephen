/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "navigate")
@ApplicationScoped
public class navigate {

    
   private String[] winPages = {
        "a", "b", "c", "victory"};
   private String loosePage = "defeat";
    
   public String playgame(int index){
       
       index++;
       long play = Math.round(Math.random());
       if (play == 1){
           return winPages[index];
       }
       else{
           return loosePage;
       }
   }
   
}
