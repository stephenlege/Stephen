/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.pojos;

/**
 *
 * @author Greg
 */
public class Employee {
    private Name name;
    private Company company;

    public Employee(Name name, Company company) {
        this.name = name;
        this.company = company;
    }

    public Name getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }
    
    public String processEmployee(){
        if(Math.random() < .5) return("accepted");
        else return ("rejected");
    }

    public Employee() {
    }
    
    
}
