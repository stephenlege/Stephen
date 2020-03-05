/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

@Named(value="colors2")
@RequestScoped
public class Colors2 extends Colors1{

    /**
     * Creates a new instance of Colors2
     */


   @Override
   public String showColors(){
       System.out.println("Color2:showColors()");
       return "show-colors-2";
   }
    
}
