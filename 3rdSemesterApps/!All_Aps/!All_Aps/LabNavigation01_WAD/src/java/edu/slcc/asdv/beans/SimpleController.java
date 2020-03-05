/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojos.Utilities;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;


/**
 *
 * @author Greg
 */
@Named(value = "simpleController")
@RequestScoped
public class SimpleController {

    
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    /**
     * Creates a new instance of SimpleController
     */
    public SimpleController() {
    }
    
    public String doNavigation(){
        if(message.trim().length() < 2)
            return "too-short";
        else{
            String [] results = {"page1", "page2", "page3"};
        return (Utilities.randomElement(results));
        }
        
    }
    
}
