/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;


@Named(value = "formSettings")
@SessionScoped
 
public class formSettings implements Serializable {
    private boolean isLight = true;
    private String buttonColor = "black";
    
    
    
    public String getBodyStyleClass() {
        if (isLight) {
            buttonColor= "black";
            return ("light");
        } else {
            buttonColor = "white";
            return ("dark");
        }
    }

    public String getButtonColor() {
        return buttonColor;
    }
    
    
    public void inverseVideo(ActionEvent event) {
        isLight = !isLight;
    }
    
    public void valueChanged(ValueChangeEvent event) {
    isLight = !isLight;
}
}