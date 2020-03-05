/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Greg
 */
@Named(value = "user")
@SessionScoped
public class UserBean implements Serializable{
private String name="";
private String password;

    public UserBean(String name, String passord) {
        this.name = name;
        this.password = passord;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String passord) {
        this.password = passord;
    }

    /**
     * Creates a new instance of UserBean
     */
    public UserBean() {
    }
    
}
