/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;


import edu.slcc.asdv.pojos.BestFriend;
import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Greg
 */
@Named(value = "concat1")
@SessionScoped
public class Concat1 implements Serializable {

    private String name;
    private String day;
    private UIComponent show;
    
     BestFriend besty;
    
     
     
    public BestFriend getBesty() {
        return besty;
    }

    public void setBesty(String besty) {
        this.besty.name = besty;
    }

    private String message;

    public UIComponent getShow() {
        return show;
    }

    private String bestName = "nobody";

    public String getBestName() {
        return bestName;
    }

    public void setBestName(String bestName) {
        this.bestName = bestName;
    }
    public void setShow(UIComponent show) {
        this.show = show;
    }
  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    
    public void concat(){
        bestName = "nobody";
        message = name + " " + day;
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, message, message));
         
        
    }
  

    public void changeBestFriendName(){
       bestName = "Nick";
       
       
    }
    
    public Concat1() {
       
    }
    
}
