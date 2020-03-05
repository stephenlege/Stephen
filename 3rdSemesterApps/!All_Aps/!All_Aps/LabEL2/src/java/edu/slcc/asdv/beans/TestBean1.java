/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Greg
 */
@Named(value = "testBean1")
@ApplicationScoped
public class TestBean1 {

    private Date creationTime = new Date();
    
    private String greeting = "Helloo";

    public Date getCreationTime() {
        return creationTime;
    }

    public String getGreeting() {
        return greeting;
    }
    
    public double getRandomNumber(){
        return (Math.random());
    }
    
    
}
