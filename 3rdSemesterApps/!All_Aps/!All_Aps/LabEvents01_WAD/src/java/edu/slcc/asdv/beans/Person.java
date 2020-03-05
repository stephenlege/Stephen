package edu.slcc.asdv.beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "person")
@RequestScoped
public class Person {

    private String firstName, lastName, emailAddress;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String doRegistration(){
        if (isAnyEmpty(firstName,lastName,emailAddress))
            return "missing-input";
        else
            return "confirm-registration";
    }
    
    private boolean isAnyEmpty(String...values){
        for (String value: values){
            if(isEmpty(value))
                return true;
            
        }return false;
    }
    
    private boolean isEmpty(String value){
        return value == null || value.trim().length() == 0;
    }
    public Person() {
    }
    
}
