/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Greg
 */
@Named(value = "colors1")
@RequestScoped
public class Colors1 {

    /**
     * Creates a new instance of Colors1
     */
    protected String color1, color2, color3, color4;

    
    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public void setColor3(String color3) {
        this.color3 = color3;
    }

    public void setColor4(String color4) {
        this.color4 = color4;
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public String getColor3() {
        return color3;
    }

    public String getColor4() {
        return color4;
    }

    public String showColors() {
        System.out.println("Color1:showColors()");
        return "show-colors-1";
    }

}
