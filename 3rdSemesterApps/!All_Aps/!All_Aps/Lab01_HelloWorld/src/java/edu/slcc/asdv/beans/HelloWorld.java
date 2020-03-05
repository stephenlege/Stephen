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
@Named(value = "hello")
@RequestScoped
public class HelloWorld {

    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
    }
    public String getMessage(){
        return "Hello World";
    }
    
    public static String getMessageStatic(){
        return "Hello World from a static method!";
    }
   public String insertMessage(String mess){
       return (mess);
   }
    
}
