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
@Named(value="colors3")
@RequestScoped
public class Colors3 extends Colors1{

   public Colors3(){
       color1 ="orange";
       color2 = "#ff0000";
       color3 = "#008000";
       color4 = "#0000ff";
   }
   @Override
   public String showColors(){
       System.out.println("Color3:showColors()");
       return "show-colors-3";
   }
}
