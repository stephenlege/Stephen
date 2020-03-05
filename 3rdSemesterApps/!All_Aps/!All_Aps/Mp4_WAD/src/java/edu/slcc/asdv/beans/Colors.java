/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Greg
 */
@Named(value = "colors")
@SessionScoped
public class Colors implements Serializable {

    private final String[] colorNames
            = {"red", "orange", "yellow", "green", "blue", "purple"};

    protected static String bgColorChoice = "red";
    protected static String fgColorChoice = "orange";

    public void setBgColorChoice(String bgColorChoice) {
            this.bgColorChoice = bgColorChoice;
    }

    public void setFgColorChoice(String fgColorChoice) {
            this.fgColorChoice = fgColorChoice;
    }

    public String getBgColorChoice() {
        return bgColorChoice;
    }

    public String getFgColorChoice() {
        return fgColorChoice;
    }

    public String[] getColorNames() {
        return colorNames;
    }

    public Colors() {
        for (int i = 0; i < colorNames.length; i++) {
            String colorName = colorNames[i];
        }

    }
}
