/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.pojos;

import java.io.Serializable;

/**
 *
 * @author Greg
 */
public class Email implements Serializable{
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Email(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email{" + "email=" + email + '}';
    }
    
}
