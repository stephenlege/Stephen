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
@Named(value = "nameSettings")
@SessionScoped
public class nameSettings implements Serializable {

   private String fName = "default";
   private String lName = "default";
   private String email = "default";

    public String getfName() {
        return fName;
    }
   
    public String getlName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
   
   
    public nameSettings() {
    }
    
}
