/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import edu.slcc.asdv.pojos.Company;
import edu.slcc.asdv.pojos.Employee;
import edu.slcc.asdv.pojos.Name;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "employeeBean")
@RequestScoped
public class EmployeeBean extends Employee {

    public EmployeeBean(Name name, Company company) {
        super(name, company);
    }
    
    public EmployeeBean(){
     super (new Name("jan", "Databaseux"), 
             new Company("DBaseSoft.com", "Developing Database Solutions"));   
        
    }

    
    
}
