/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "testRequestScoped")
@RequestScoped
public class TestRequestScoped {

    /**
     * Creates a new instance of TestRequestScoped
     */
    public TestRequestScoped() {
        
        System.out.println("Constructor called " + x);
    }
    private String x = "abc";

    /**
     * Get the value of x
     *
     * @return the value of x
     */
    public String getX() {
        return x;
    }

    /**
     * Set the value of x
     *
     * @param x new value of x
     */
    public void setX(String x) {
        this.x = x;
    }

    
}
