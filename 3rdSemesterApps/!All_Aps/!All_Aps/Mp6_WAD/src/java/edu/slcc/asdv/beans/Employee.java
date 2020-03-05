/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.util.HashMap;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "employee")
@RequestScoped
public class Employee {

    HashMap<String, String> employees = new HashMap<>();
    private String id;
    
    public Employee() {
        employees.put("1", "Harry Hackleberry");
         employees.put("2", "Harry Fin");
          employees.put("3", "Barry WhiteSnake");
           employees.put("4", "Jerry Garcia");
           employees.put("1", "Harry Hoodinosaur");
    }

    public HashMap<String, String> getEmployees() {
        return employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    
    
}
