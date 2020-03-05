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
public class Company {
    private String companyName, business;

    public Company(String companyName, String business) {
        this.companyName = companyName;
        this.business = business;
    }
    

    public String getCompanyName() {
        return companyName;
    }

    public String getBusiness() {
        return business;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setBusiness(String business) {
        this.business = business;
    }
    
    
}
