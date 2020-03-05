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
@Named(value = "integerArray")
@RequestScoped
public class IntegerArray {

    Integer [] intArray = {-1,-10,5,17,15,19,22,24,100, -100, 55, -22, 2,3,4,5,-5};

    public Integer[] getIntArray() {
        return intArray;
    }
  
    
    
}
