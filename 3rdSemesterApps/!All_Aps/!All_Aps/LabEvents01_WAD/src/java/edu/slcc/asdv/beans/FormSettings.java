/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Greg
 */
@Named(value = "formSettings")
@SessionScoped
public class FormSettings implements Serializable {

    private boolean isNormalSize = true;

    public void setNormalSize(ActionEvent e) {
        
        isNormalSize = true;
    }
    
    public String getBodyStyleClass(){
        if(isNormalSize){
            return ("normalSize");
        }else{
            return ("largeSize");
        }
    }

    public FormSettings() {
    }
     public void setLargeSize(ActionEvent e) {
        isNormalSize = false;
    }
    

}
