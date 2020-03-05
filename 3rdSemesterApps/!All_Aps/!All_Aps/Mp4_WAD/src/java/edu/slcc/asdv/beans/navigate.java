/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.beans.Colors;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
//import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "navigate")
@SessionScoped
public class navigate implements Serializable {

   
   private String[] winPages = {
        "a", "b", "c", "victory"};
   private String loosePage = "defeat";
    
   public String playgame(int index){
       if (!Colors.bgColorChoice.equals(Colors.fgColorChoice)){
       index++;
       long play = Math.round(Math.random());
       if (play == 1){
           return winPages[index];
       }
       else{
           return loosePage;
       }
   }else{
           FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Pick Different BackGround and foreGround Colors!"));
           Colors.bgColorChoice = "red";
           Colors.fgColorChoice = "orange";
           return winPages[0];
                   }
   }
   
}
