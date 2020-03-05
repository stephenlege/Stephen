/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Greg
 */
@Named(value = "employeeBean")
@SessionScoped
public class EmployeeBean implements Serializable {

    //private Employee employee;
    
    
    public EmployeeBean() {
    }
    
}
