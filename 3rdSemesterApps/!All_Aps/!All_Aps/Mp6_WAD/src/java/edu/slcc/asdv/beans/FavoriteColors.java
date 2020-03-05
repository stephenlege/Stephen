/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.slcc.asdv.beans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Greg
 */
@Named(value = "favoriteColors")
@ViewScoped
public class FavoriteColors implements Serializable{

   ArrayList<String> colors = new ArrayList<>();
   
    public FavoriteColors() {
        colors.add("red");
        colors.add("blue");
        colors.add("green");
        colors.add("orange");
    }

    public ArrayList<String> getColors() {
        return colors;
    }
    
    
    
}
