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
@Named(value = "timeBean")
@RequestScoped
public class TimeBean {

    /**
     * Creates a new instance of TimeBean
     */
    public TimeBean() {
    }
    
}
